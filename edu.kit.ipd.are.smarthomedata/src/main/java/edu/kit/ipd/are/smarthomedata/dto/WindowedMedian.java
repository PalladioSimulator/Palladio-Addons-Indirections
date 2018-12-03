package edu.kit.ipd.are.smarthomedata.dto;

public class WindowedMedian {
	public final PlugIdentifier plug;
	public final float value;
	public final Interval interval;
	public final MutableInterval origins;

	public WindowedMedian(PlugIdentifier plug, float value, Interval interval, MutableInterval originTimes) {
		this.plug = plug;
		this.value = value;
		this.interval = interval;
		this.origins = originTimes;
	}

	@Override
	public String toString() {
		return "WindowedMedian [" + plug + ": " + value + " in " + interval + ", origins: " + origins + "]";
	}

	public boolean isOverallMedian() {
		return (this.plug.plugId == -1L && this.plug.householdId == -1L && this.plug.houseId == -1);
	}

	public String serialize() {
		return "" + this.plug.plugId + "," + this.plug.householdId + "," + this.plug.houseId + "," + this.value + ","
				+ this.interval.start + "," + this.interval.end + "," + this.origins.start + "," + this.origins.end;
	}

	public static WindowedMedian deserialize(String s) {
		String[] f = s.split(",");
		PlugIdentifier plugIdentifier = new PlugIdentifier(Long.valueOf(f[0]), Long.valueOf(f[1]), Long.valueOf(f[2]));
		Interval interval = new Interval(Long.valueOf(f[4]), Long.valueOf(f[5]));
		MutableInterval originTimes = new MutableInterval(Long.valueOf(f[6]), Long.valueOf(f[7]));
		return new WindowedMedian(plugIdentifier, Float.valueOf(f[3]), interval, originTimes);
	}
}
