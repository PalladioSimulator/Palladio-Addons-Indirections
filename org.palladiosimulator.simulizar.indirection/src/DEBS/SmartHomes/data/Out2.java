package DEBS.SmartHomes.data;

public class Out2 extends Out {
	private final float predicted_load;

	public Out2(long house_id, long ts_start,  float predicted_load) {
		super(house_id, ts_start);
		this.predicted_load = predicted_load;
	}

	public float getPredicted_load() {
		return predicted_load;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Out2 [predicted_load=").append(predicted_load).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Float.floatToIntBits(predicted_load);
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
		Out2 other = (Out2) obj;
		if (Float.floatToIntBits(predicted_load) != Float.floatToIntBits(other.predicted_load))
			return false;
		return true;
	}
}
