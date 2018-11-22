package DEBS.SmartHomes.data;

public class Out4 extends Out {
	private final long ts_stop;
	private final float percentage;
	public Out4(long house_id, long ts_start, long ts_stop, float percentage) {
		super(house_id, ts_start);
		this.ts_stop = ts_stop;
		this.percentage = percentage;
	}
	public long getTs_stop() {
		return ts_stop;
	}
	public float getPercentage() {
		return percentage;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Out4 [ts_stop=").append(ts_stop).append(", percentage=").append(percentage).append("]");
		return builder.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Float.floatToIntBits(percentage);
		result = prime * result + (int) (ts_stop ^ (ts_stop >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Out4 other = (Out4) obj;
		if (Float.floatToIntBits(percentage) != Float.floatToIntBits(other.percentage))
			return false;
		if (ts_stop != other.ts_stop)
			return false;
		return true;
	}
}
