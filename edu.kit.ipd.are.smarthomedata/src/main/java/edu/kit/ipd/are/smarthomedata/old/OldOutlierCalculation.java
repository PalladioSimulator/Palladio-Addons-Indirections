package edu.kit.ipd.are.smarthomedata.old;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

import edu.kit.ipd.are.smarthomedata.dto.OutlierValue;
import edu.kit.ipd.are.smarthomedata.dto.WindowedValue;

// accepts both overall values and individual house 
public class OldOutlierCalculation implements Consumer<WindowedValue> {
	private Long ts_start = null;
	private Long ts_stop = null;
	
	private Double overallMedian = null;
	private Map<Long, Double> houseToMedian = null;
	
	public OldOutlierCalculation(Consumer<OutlierValue> callback) {
	}

	@Override
	public void accept(WindowedValue wm) {
//		if (ts_start == null && ts_stop == null) {
//			// initial measurement
//			initialize(wm);
//		} else if (wm.ts_start > ts_start) {
//			// new block begins
//			calculateOutlierValuesAndEmit();
//			initialize(wm);
//			addValue(wm);
//		} else if (wm.ts_start == ts_start && wm.ts_stop == ts_stop) {
//			addValue(wm);
//		} else {
//			throw new IllegalStateException();
//		}
	}
	
	private void addValue(WindowedValue wm) {
		if (wm.isOverallMedian()) {
			if (overallMedian != null) {
				throw new IllegalStateException();
			}
			
			overallMedian = wm.value;
//		} else if (wm.isHouseMedian()) {
//			if (houseToMedian.containsKey(wm.plug.houseId)) {
//				throw new IllegalStateException();
//			}
//			
//			houseToMedian.put(wm.plug.houseId, wm.value);
		} else {
			System.out.println(this + ": Ignoring: " + wm.toString());
		}
	}

	private void calculateOutlierValuesAndEmit() {
		Objects.requireNonNull(overallMedian);
		
		for (var entry : houseToMedian.entrySet()) {
			System.out.println(entry.getKey() + " --> " + entry.getValue() + " vs. " + overallMedian);
		}
	}

	private void initialize(WindowedValue wm) {
//		this.ts_start = wm.ts_start;
//		this.ts_stop = wm.ts_stop;
		
		this.houseToMedian = new HashMap<>();
		this.overallMedian = null;
	}
}
