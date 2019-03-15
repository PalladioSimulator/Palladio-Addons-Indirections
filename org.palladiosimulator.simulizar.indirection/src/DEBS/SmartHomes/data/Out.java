package DEBS.SmartHomes.data;

public class Out {
	private final long house_id;
	private final long ts_start;
	public Out(long house_id, long ts_start) {
		this.house_id = house_id;
		this.ts_start = ts_start;
	}
	public long getHouse_id() {
		return house_id;
	}
	public long getTs_start() {
		return ts_start;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Out [house_id=").append(house_id).append(", ts_start=").append(ts_start).append("]");
		return builder.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (house_id ^ (house_id >>> 32));
		result = prime * result + (int) (ts_start ^ (ts_start >>> 32));
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
		Out other = (Out) obj;
		if (house_id != other.house_id)
			return false;
		if (ts_start != other.ts_start)
			return false;
		return true;
	}
	}
