package edu.kit.ipd.are.smarthomedata.dto;

public class Interval {
	public final long start;
	public final long end;
	
	public Interval(long start, long end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (end ^ (end >>> 32));
		result = prime * result + (int) (start ^ (start >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Interval other = (Interval) obj;
		if (end != other.end)
			return false;
		if (start != other.start)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Interval ["+ start + " - " + end + "]";
	}

	public MutableInterval asMutableInterval() {
		return new MutableInterval(start, end);
	}
}
