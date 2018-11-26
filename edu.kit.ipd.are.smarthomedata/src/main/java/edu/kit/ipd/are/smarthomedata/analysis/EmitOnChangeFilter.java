package edu.kit.ipd.are.smarthomedata.analysis;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import edu.kit.ipd.are.smarthomedata.dto.OutlierValue;

public class EmitOnChangeFilter implements Consumer<OutlierValue> {
	private final Map<Long, Double> values = new HashMap<>();
	private final Consumer<OutlierValue> callback;
	
	public EmitOnChangeFilter(Consumer<OutlierValue> callback) {
		this.callback = callback;
	}

	@Override
	public void accept(OutlierValue entry) {
		if (!values.containsKey(entry.houseId) || (entry.outlierRatio != values.get(entry.houseId))) {
			values.put(entry.houseId, entry.outlierRatio);
			emit(entry);
		}
	}

	private void emit(OutlierValue value) {
		callback.accept(value);
	}
}
