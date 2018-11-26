package edu.kit.ipd.are.smarthomedata.analysis;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.DoubleStream;

import edu.kit.ipd.are.smarthomedata.dto.PlugIdentifier;
import edu.kit.ipd.are.smarthomedata.dto.WindowedMedian;

public class MedianAllPlugs implements Consumer<WindowedMedian> {
	private Long ts_start = null;
	private Long ts_stop = null;

	private Map<PlugIdentifier, Float> values;
	private Consumer<WindowedMedian> callback;
	
	public MedianAllPlugs(Consumer<WindowedMedian> callback) {
		this.callback = callback;
	}

	@Override
	public void accept(WindowedMedian wm) {
		if (ts_start == null && ts_stop == null) {
			// initial measurement
			initialize(wm);
		} else if (wm.ts_start > ts_start) {
			// new block begins
			calculateOverallMedianAndEmit();
			initialize(wm);
			addValue(wm);
		} else if (wm.ts_start == ts_start && wm.ts_stop == ts_stop) {
			addValue(wm);
		} else {
			throw new IllegalStateException();
		}
	}

	private void initialize(WindowedMedian wm) {
//		System.out.println("Initializing to " + wm.toString());
		this.ts_start = wm.ts_start;
		this.ts_stop = wm.ts_stop;
		this.values = new HashMap<>();
	}

	private void addValue(WindowedMedian wm) {
		Objects.requireNonNull(wm);
		if (this.values.containsKey(wm.plug)) {
			throw new IllegalStateException();
		} else {
			this.values.put(wm.plug, wm.value);
		}
	}

	private void calculateOverallMedianAndEmit() {
//		System.out.println(values.values().stream().mapToDouble(f -> (double) f).sorted().mapToObj(Double::toString).collect(Collectors.joining(", ")));
		//double median = median(values.values().stream().mapToDouble(f -> (double) f), values.values().size());
		double average = values.values().stream().mapToDouble(f -> (double) f).average().getAsDouble();
		callback.accept(new WindowedMedian(new PlugIdentifier(-1L, -1L, -1L), (float) average, ts_start, ts_stop));
	}

	private static double median(DoubleStream s, int size) {
		return size % 2 == 0
				? s.sorted().skip(size / 2 - 1).limit(2).average().getAsDouble()
				: s.sorted().skip(size / 2).findFirst().getAsDouble();
	}
}
