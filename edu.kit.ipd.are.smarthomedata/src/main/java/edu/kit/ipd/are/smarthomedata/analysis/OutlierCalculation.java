package edu.kit.ipd.are.smarthomedata.analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import edu.kit.ipd.are.smarthomedata.dto.Interval;
import edu.kit.ipd.are.smarthomedata.dto.MutableInterval;
import edu.kit.ipd.are.smarthomedata.dto.OutlierValue;
import edu.kit.ipd.are.smarthomedata.dto.PlugIdentifier;
import edu.kit.ipd.are.smarthomedata.dto.WindowedValue;

public class OutlierCalculation implements Consumer<WindowedValue> {
	private class CalculationWindow {
		public final Interval interval;
		public final Map<Long, Map<PlugIdentifier, Double>> houseIdToPlugIdentifierToValue;
		public Double overallMedian = null;
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
	synchronized public void accept(WindowedValue wm) {
//		System.out.println("Accepting " + wm.toString());
		try {
			if (currentWindow() == null || wm.interval.start > currentWindow().interval.start) {
				pushCalculationWindow(wm);
			}

			if (getWindowFor(wm.interval) == null) {

				System.out.println("WARNING: Unexpected interval " + wm.interval.toString() + ". Windows: "
						+ windows.stream().map(it -> "" + it.interval.start + "-" + it.interval.end)
								.collect(Collectors.joining(",")));
				return;
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
		// we know how many times hasNext() will return true. We do not want to look at
		// the last window
		var iterator = windows.iterator();
		int s = windows.size();
		for (int i = 0; i < windows.size() - 1; i++) {
			CalculationWindow calculationWindow = iterator.next();
//			if (calculationWindow.houseIdToPlugIdentifierToValue.size() == 40
//					&& calculationWindow.overallMedian != null) {
			if (calculationWindow.overallMedian != null) {
				calculateOutlierValuesAndEmit(calculationWindow);
				iterator.remove();
				MutableInterval originDeltas = calculationWindow.origins.copy();
				originDeltas.shift(-System.currentTimeMillis()).scale(-1);
				int houseCount = calculationWindow.houseIdToPlugIdentifierToValue.size();
				int totalPlugs = calculationWindow.houseIdToPlugIdentifierToValue.entrySet().stream()
						.mapToInt(it -> it.getValue().size()).sum();
				System.out.println("Window " + i + "/" + (s - 1) + ", range: " + calculationWindow.interval.toString()
						+ ", ages: " + originDeltas.toString() + ", houses: " + houseCount + ", plugs: " + totalPlugs);
			}
		}
	}

	private void calculateOutlierValuesAndEmit(CalculationWindow window) {
		for (var e : window.houseIdToPlugIdentifierToValue.entrySet()) {
			long count = e.getValue().values().stream().filter(it -> it > window.overallMedian).count();
			callback.accept(new OutlierValue(e.getKey(), (1.d * count) / e.getValue().values().size(), window.interval,
					window.origins));
		}
	}

	private void pushCalculationWindow(WindowedValue wm) {
		windows.add(new CalculationWindow(wm.interval, wm.origins.copy()));
	}

	private void acceptPlugMedian(WindowedValue wm) {
//		System.out.println("Handling Plug Median " + wm.toString());

		CalculationWindow window = Objects.requireNonNull(getWindowFor(wm.interval));
		Map<Long, Map<PlugIdentifier, Double>> houseIdToPlugIdentifierToValue = window.houseIdToPlugIdentifierToValue;
		Map<PlugIdentifier, Double> plugIdentifierToValue = houseIdToPlugIdentifierToValue
				.computeIfAbsent(wm.plug.houseId, (k) -> new HashMap<>());

		if (plugIdentifierToValue.containsKey(wm.plug)) {
			throw new IllegalStateException("Value for " + wm.plug + " already present.");
		}

		plugIdentifierToValue.put(wm.plug, wm.value);
		window.origins.extendToInclude(wm.origins);
	}

	private void acceptOverallMedian(WindowedValue wm) {
//		System.out.println("Handling Overall Median " + wm.toString());

		CalculationWindow window = Objects.requireNonNull(getWindowFor(wm.interval));
		if (window.overallMedian != null) {
			throw new IllegalStateException(
					"Median for " + wm.interval + " already present. (" + window.overallMedian + ")");
		}

		window.overallMedian = wm.value;
		window.origins.extendToInclude(wm.origins);
	}
}
