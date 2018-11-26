package edu.kit.ipd.are.smarthomedata.dto;

public class WindowedMedian {
	public final float value;
	public final long ts_start;
	public final long ts_stop;
	public final PlugIdentifier plug;

	public WindowedMedian(PlugIdentifier plug, float value, long startTimestamp, long endTimestamp) {
		this.plug = plug;
		this.value = value;
		this.ts_start = startTimestamp;
		this.ts_stop = endTimestamp;
	}

	@Override
	public String toString() {
		return "WindowedMedian [" + plug + ": " + value + " from " + ts_start + " to " + ts_stop + "]";
	}
	
	public boolean isHouseMedian() {
		return (this.plug.plugId == -1L && this.plug.householdId == -1L);
	}

	public boolean isOverallMedian() {
		return (this.plug.plugId == -1L && this.plug.householdId == -1L && this.plug.houseId == -1);
	}
}
