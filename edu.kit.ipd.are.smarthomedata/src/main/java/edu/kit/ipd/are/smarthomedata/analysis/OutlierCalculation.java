package edu.kit.ipd.are.smarthomedata.analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

import edu.kit.ipd.are.smarthomedata.dto.Interval;
import edu.kit.ipd.are.smarthomedata.dto.MutableInterval;
import edu.kit.ipd.are.smarthomedata.dto.OutlierValue;
import edu.kit.ipd.are.smarthomedata.dto.PlugIdentifier;
import edu.kit.ipd.are.smarthomedata.dto.WindowedMedian;

public class OutlierCalculation implements Consumer<WindowedMedian> {
	private class CalculationWindow {
		public final Interval interval;
		public final Map<Long, Map<PlugIdentifier, Float>> houseIdToPlugIdentifierToValue;
		public Float overallMedian = null;
		public final MutableInterval origins;

		public CalculationWindow(Interval interval, MutableInterval origins) {
			this.interval = interval;
			this.houseIdToPlugIdentifierToValue = new HashMap<>();
			this.origins = origins;
		}
	}

	private Consumer<OutlierValue> callback;
	private List<CalculationWindow> windows = new ArrayList<>();

	public OutlierCalculation(Consumer<OutlierValue> callback) {
		this.callback = callback;
	}

	private CalculationWindow getWindowFor(Interval interval) {
		for (var cw : windows) {
			if (cw.interval.equals(interval)) {
				return cw;
			}
		}

		return null;
	}

	private CalculationWindow currentWindow() {
		return windows.isEmpty() ? null : windows.get(windows.size() - 1);
	}

	@Override
	synchronized public void accept(WindowedMedian wm) {
//		System.out.println("Accepting " + wm.toString());
		try {
		if (currentWindow() == null || wm.interval.start > currentWindow().interval.start) {
			pushCalculationWindow(wm);
		}

		if (wm.isOverallMedian()) {
			acceptOverallMedian(wm);
		} else {
			acceptPlugMedian(wm);
		}
		
		emitAllFinishedWindowsButHead();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private void emitAllFinishedWindowsButHead() {
		// we know how many times hasNext() will return true. We do not want to look at the last window
		var iterator = windows.iterator();
		for (int i = 0; i < windows.size() - 1; i++) {
			CalculationWindow calculationWindow = iterator.next();
			if (calculationWindow.houseIdToPlugIdentifierToValue.size() == 40 && calculationWindow.overallMedian != null) {
				calculateOutlierValuesAndEmit(calculationWindow);
				iterator.remove();
				MutableInterval originDeltas = calculationWindow.origins.copy();
				originDeltas.shift(-System.currentTimeMillis());
				System.out.println("Emitted window, ages: " + originDeltas.toString());
			}
		}
	}

	private void calculateOutlierValuesAndEmit(CalculationWindow window) {
		for (var e : window.houseIdToPlugIdentifierToValue.entrySet()) {
			long count = e.getValue().values().stream().filter(it -> it > window.overallMedian).count();
			callback.accept(
					new OutlierValue(e.getKey(), (1.d * count) / e.getValue().values().size(), window.interval, window.origins));
		}
	}

	private void pushCalculationWindow(WindowedMedian wm) {
		windows.add(new CalculationWindow(wm.interval, wm.origins.copy()));
	}

	private void acceptPlugMedian(WindowedMedian wm) {
//		System.out.println("Handling Plug Median " + wm.toString());
		
		CalculationWindow window = Objects.requireNonNull(getWindowFor(wm.interval));
		Map<Long, Map<PlugIdentifier, Float>> houseIdToPlugIdentifierToValue = window.houseIdToPlugIdentifierToValue;
		Map<PlugIdentifier, Float> plugIdentifierToValue = houseIdToPlugIdentifierToValue
				.computeIfAbsent(wm.plug.houseId, (k) -> new HashMap<>());

		if (plugIdentifierToValue.containsKey(wm.plug)) {
			throw new IllegalStateException("Value for " + wm.plug + " already present.");
		}

		plugIdentifierToValue.put(wm.plug, wm.value);
		window.origins.extendToInclude(wm.origins);
	}

	private void acceptOverallMedian(WindowedMedian wm) {
//		System.out.println("Handling Overall Median " + wm.toString());
		
		CalculationWindow window = Objects.requireNonNull(getWindowFor(wm.interval));
		if (window.overallMedian != null) {
			throw new IllegalStateException("Median for " + wm.interval + " already present. (" + window.overallMedian + ")");
		}
		
		window.overallMedian = wm.value;
		window.origins.extendToInclude(wm.origins);
	}
}
