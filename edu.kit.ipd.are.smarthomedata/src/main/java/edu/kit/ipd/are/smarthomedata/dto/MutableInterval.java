package edu.kit.ipd.are.smarthomedata.dto;

public class MutableInterval {
	public long start;
	public long end;
	
	public MutableInterval(long start, long end) {
		this.start = start;
		this.end = end;
	}
	
	public MutableInterval extendToInclude(long time) {
		if (time < start) {
			start = time;
		} else if (time > end) {
			end = time;
		}
		return this;
	}
	
	public MutableInterval shift(long delta) {
		this.start += delta;
		this.end += delta;
		
		return this;
	}
	
	public MutableInterval scale(long by) {
		if (by < 0) {
			long temp = this.start;
			this.start = this.end * by;
			this.end = temp * by;
		} else {
			this.start = this.start * by;
			this.end = this.end * by;
		}
		
		return this;
	}
	
	public MutableInterval extendToInclude(MutableInterval other) {
		extendToInclude(other.start);
		extendToInclude(other.end);
		return this;
	}
	
	public Interval asInterval() {
		return new Interval(start, end);
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
		MutableInterval other = (MutableInterval) obj;
		if (end != other.end)
			return false;
		if (start != other.start)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "MutableInterval ["+ start + " - " + end + "]";
	}

	public MutableInterval copy() {
		return new MutableInterval(start, end);
	}

}
