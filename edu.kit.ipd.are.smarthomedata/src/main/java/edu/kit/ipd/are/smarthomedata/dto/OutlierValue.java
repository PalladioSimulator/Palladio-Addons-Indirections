package edu.kit.ipd.are.smarthomedata.dto;

public class OutlierValue {

	public final Long houseId;
	public final double outlierRatio;
	public final Long ts_start;
	public final Long ts_stop;

	public OutlierValue(Long houseId, double outlierRatio, Long ts_start, Long ts_stop) {
		this.houseId = houseId;
		this.outlierRatio = outlierRatio;
		this.ts_start = ts_start;
		this.ts_stop = ts_stop;
	}

	@Override
	public String toString() {
		return "[House " + houseId + " has " + outlierRatio * 100 + "% outliers from " + ts_start + " to " + ts_stop + "]";
	}

	public Long houseId() {
		return houseId;
	}

	public double outlierRatio() {
		return outlierRatio;
	}

	
}
