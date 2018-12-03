package edu.kit.ipd.are.smarthomedata.analysis;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

import edu.kit.ipd.are.smarthomedata.dto.Interval;
import edu.kit.ipd.are.smarthomedata.dto.MutableInterval;
import edu.kit.ipd.are.smarthomedata.dto.PlugIdentifier;
import edu.kit.ipd.are.smarthomedata.dto.WindowedMedian;

public class AverageAllPlugs implements Consumer<WindowedMedian> {
	private Interval interval = null;
	private MutableInterval origins = null;

	private Map<PlugIdentifier, Float> values;
	private Consumer<WindowedMedian> callback;

	public AverageAllPlugs(Consumer<WindowedMedian> callback) {
		this.callback = callback;
	}

	@Override
	public void accept(WindowedMedian wm) {
		try {
			if (interval == null) {
				// initial measurement
				initialize(wm);
			} else if (wm.interval.start > interval.start) {
				// new block begins
				calculateOverallMedianAndEmit();
				initialize(wm);
				addValue(wm);
			} else if (wm.interval.equals(interval)) {
				addValue(wm);
			} else {
				throw new IllegalStateException("Medians were not in order: current interval: " + interval.toString()
						+ ", got: " + wm.interval.toString() + ".");
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private void initialize(WindowedMedian wm) {
//		System.out.println("Initializing to " + wm.toString());
		this.interval = wm.interval;
		this.origins = wm.origins.copy();
		this.values = new HashMap<>();
	}

	private void addValue(WindowedMedian wm) {
		Objects.requireNonNull(wm);
		if (this.values.containsKey(wm.plug)) {
			throw new IllegalStateException();
		} else {
			this.values.put(wm.plug, wm.value);
			this.origins.extendToInclude(wm.origins);
		}
	}

	private void calculateOverallMedianAndEmit() {
//		System.out.println(values.values().stream().mapToDouble(f -> (double) f).sorted().mapToObj(Double::toString).collect(Collectors.joining(", ")));
		// double median = median(values.values().stream().mapToDouble(f -> (double) f),
		// values.values().size());
		double average = values.values().stream().mapToDouble(f -> (double) f).average().getAsDouble();
		callback.accept(new WindowedMedian(new PlugIdentifier(-1L, -1L, -1L), (float) average, interval, origins));
	}
}