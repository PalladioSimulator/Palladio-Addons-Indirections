package edu.kit.ipd.are.smarthomedata.old;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

import edu.kit.ipd.are.smarthomedata.dto.OutlierValue;
import edu.kit.ipd.are.smarthomedata.dto.PlugIdentifier;
import edu.kit.ipd.are.smarthomedata.dto.WindowedMedian;

public class NewAndBrokenOutlierCalculation implements Consumer<WindowedMedian> {
	private Long ts_start = null;
	private Long ts_stop = null;

	private Long ts_start_prev = null;
	private Long ts_stop_prev = null;

	// house identifier to measurements for this house
	private Map<Long, Map<PlugIdentifier, Float>> values;
	private Map<Long, Map<PlugIdentifier, Float>> values_prev;

	private Float overallMedian;
	private Float overallMedian_prev;

	private Consumer<OutlierValue> callback;

	public NewAndBrokenOutlierCalculation(Consumer<OutlierValue> callback) {
		this.callback = callback;
	}

	@Override
	synchronized public void accept(WindowedMedian wm) {
//		try {
//			if (ts_start == null && ts_stop == null) {
//				// initial measurement
//				initialize(wm);
//			} else if (wm.ts_start > ts_start) {
//				// new block begins
//				shiftBack(wm);
//				initialize(wm);
//				addValue(wm);
//				calculateOutliersAndEmit(wm);
//			} else if (wm.ts_start < ts_start_prev && wm.ts_stop < ts_stop_prev) {
//				addValue(wm);
//			}
//		} catch (Exception e) {
//			e.printStackTrace(System.out);
//		}
	}

	private void shiftBack(WindowedMedian wm) {
		if (this.ts_start_prev != null) {
			throw new IllegalStateException(
					"Value for " + this.ts_start_prev + " to " + this.ts_stop_prev + " was not emitted.");
		}

		this.ts_start_prev = this.ts_start;
		this.ts_stop_prev = this.ts_stop;
		this.values_prev = this.values;
		this.overallMedian_prev = this.overallMedian;
	}

	private void initialize(WindowedMedian wm) {
//		this.ts_start = wm.ts_start;
//		this.ts_stop = wm.ts_stop;
		this.values = new HashMap<>();
		this.overallMedian = null;
	}

	private Boolean isCurrentBuffer(WindowedMedian wm) {
//		if (wm.ts_start == this.ts_start && wm.ts_stop == this.ts_stop) {
//			return true;
//		} else if (wm.ts_start == this.ts_start_prev && wm.ts_stop == this.ts_stop_prev) {
//			return false;
//		} else {
//			return null;
//		}
		return null;
	}

	private void addValue(WindowedMedian wm) {
		Objects.requireNonNull(wm);

		Boolean currentBuffer = Objects.requireNonNull(isCurrentBuffer(wm));
		if (currentBuffer) {
			if (wm.isOverallMedian()) {
				Objects.requireNonNull(overallMedian);
				if (overallMedian != null) {
					throw new IllegalStateException();
				}

				overallMedian = wm.value;
			} else {
				appendMedian(wm, values);
			}
		} else {
			if (wm.isOverallMedian()) {
				if (overallMedian_prev != null) {
					throw new IllegalStateException();
				}

				overallMedian_prev = wm.value;
				if (!canEmit(ts_start_prev, ts_stop_prev)) {
					throw new IllegalStateException("Expected to emit previous buffer, but not possible");
				} else {
					calculateOutliersAndEmit(wm);
				}
			} else {
				appendMedian(wm, Objects.requireNonNull(values_prev, "Buffer already emitted (" + wm.toString() + ")"));
			}
		}
	}

	private void appendMedian(WindowedMedian wm, Map<Long, Map<PlugIdentifier, Float>> map) {
		Long houseId = wm.plug.houseId;
		Map<PlugIdentifier, Float> housePlugs = map.computeIfAbsent(houseId, it -> new HashMap<>());

		if (housePlugs.containsKey(wm.plug)) {
			throw new IllegalStateException();
		} else {
			housePlugs.put(wm.plug, wm.value);
		}
	}

	private boolean canEmit(Long ts_start, Long ts_stop) {
		if ((ts_start != this.ts_start_prev && ts_stop != this.ts_stop_prev)
				&& (ts_start != this.ts_start && ts_stop != this.ts_stop))
			throw new IllegalArgumentException();

		if (ts_start == this.ts_start && ts_stop == this.ts_stop && overallMedian != null && values != null)
			return true;
		if (ts_start == ts_start_prev && ts_stop == ts_stop_prev && overallMedian_prev != null && values_prev != null)
			return true;

		return false;
	}

	private void calculateOutliersAndEmit(WindowedMedian wm) {
		Boolean currentBuffer = isCurrentBuffer(wm);
		Objects.requireNonNull(currentBuffer, wm.toString() + " is neither " + ts_start + "-" + ts_stop + " nor "
				+ ts_start_prev + "-" + ts_stop_prev);

		if (currentBuffer) {
			emitCurrentBuffer();
		} else {
			emitPreviousBuffer();
		}
	}

	private void emitPreviousBuffer() {
		if (overallMedian_prev == null) {
			throw new IllegalStateException();
		}

		for (var e : values_prev.entrySet()) {
			long count = e.getValue().values().stream().filter(it -> it > overallMedian_prev).count();
//			callback.accept(new OutlierValue(e.getKey(), (1.d * count) / e.getValue().values().size(), ts_start_prev,
//					ts_stop_prev));
		}
		values_prev = null;
		overallMedian_prev = null;
		ts_start_prev = null;
		ts_stop_prev = null;
	}

	private void emitCurrentBuffer() {
		if (overallMedian == null) {
			throw new IllegalStateException();
		}

		for (var e : values.entrySet()) {
			long count = e.getValue().values().stream().filter(it -> it > overallMedian).count();
//			callback.accept(
//					new OutlierValue(e.getKey(), (1.d * count) / e.getValue().values().size(), ts_start, ts_stop));
		}
		values = null;
		overallMedian = null;
		ts_start = null;
		ts_stop = null;
	}
}
