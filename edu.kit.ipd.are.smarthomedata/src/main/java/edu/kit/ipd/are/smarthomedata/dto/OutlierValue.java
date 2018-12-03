package edu.kit.ipd.are.smarthomedata.dto;

public class OutlierValue {
	public final Long houseId;
	public final double outlierRatio;
	public final Interval interval;
	public final MutableInterval origins;

	public OutlierValue(Long houseId, double outlierRatio, Interval interval, MutableInterval origins) {
		this.houseId = houseId;
		this.outlierRatio = outlierRatio;
		this.interval = interval;
		this.origins = origins;
	}

	@Override
	public String toString() {
		return "[House " + houseId + " has " + outlierRatio * 100 + "% outliers in " + interval + ", measurements in "
				+ origins + "]";
	}

	public Long houseId() {
		return houseId;
	}

	public double outlierRatio() {
		return outlierRatio;
	}

	public String serialize() {
		return "" + this.houseId + "," + this.outlierRatio + "," + this.interval.start + "," + this.interval.end + ","
				+ this.origins.start + "," + this.origins.end;
	}

	public static OutlierValue deserialize(String s) {
		String[] f = s.split(",");
		Interval interval = new Interval(Long.valueOf(f[2]), Long.valueOf(f[3]));
		MutableInterval origins = new MutableInterval(Long.valueOf(f[4]), Long.valueOf(f[5]));
		return new OutlierValue(Long.valueOf(f[0]), Double.valueOf(f[1]), interval, origins);
	}
}
