package edu.kit.ipd.are.smarthomedata.analysis;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

import edu.kit.ipd.are.smarthomedata.dto.OutlierValue;
import edu.kit.ipd.are.smarthomedata.dto.PlugIdentifier;
import edu.kit.ipd.are.smarthomedata.dto.WindowedMedian;

public class OutlierCalculation implements Consumer<WindowedMedian> {
	private Long ts_start = null;
	private Long ts_stop = null;

	// house identifier to measurements for this house
	private Map<Long, Map<PlugIdentifier, Float>> values;
	private Float overallMedian;
	private Consumer<OutlierValue> callback;
	
	public OutlierCalculation(Consumer<OutlierValue> callback) {
		this.callback = callback;
	}

	@Override
	public void accept(WindowedMedian wm) {
		if (ts_start == null && ts_stop == null) {
			// initial measurement
			initialize(wm);
		} else if (wm.ts_start > ts_start) {
			// new block begins
			calculateOutliersAndEmit();
			initialize(wm);
			addValue(wm);
		} else if (wm.ts_start == ts_start && wm.ts_stop == ts_stop) {
			addValue(wm);
		} else {
			throw new IllegalStateException();
		}
	}

	private void initialize(WindowedMedian wm) {
		this.ts_start = wm.ts_start;
		this.ts_stop = wm.ts_stop;
		this.values = new HashMap<>();
		this.overallMedian = null;
	}

	private void addValue(WindowedMedian wm) {
		Objects.requireNonNull(wm);
		
		if (wm.isOverallMedian()) {
			if (overallMedian != null) {
				throw new IllegalStateException();
			}
			
			overallMedian = wm.value;
		} else {
			Long houseId = wm.plug.houseId;
			Map<PlugIdentifier, Float> housePlugs = values.computeIfAbsent(houseId, it -> new HashMap<>());
			
			if (housePlugs.containsKey(wm.plug)) {
				throw new IllegalStateException();
			} else {
				housePlugs.put(wm.plug, wm.value);
			}
		}
	}

	private void calculateOutliersAndEmit() {
		if (overallMedian == null) {
			throw new IllegalStateException();
		}
		
		for (var e : values.entrySet()) {
			long count = e.getValue().values().stream().filter(it -> it > overallMedian).count();
			callback.accept(new OutlierValue(e.getKey(), (1.d * count) / e.getValue().values().size(), ts_start, ts_stop));
		}
	}
}
