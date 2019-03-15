package DEBS.SmartHomes.data;

public class Out3 extends Out2 {
	private final long household_i;
	private final long plug_id;
	public Out3(long house_id, long ts_start, float predicted_load, long household_i, long plug_id) {
		super(house_id, ts_start, predicted_load);
		this.household_i = household_i;
		this.plug_id = plug_id;
	}
	public long getHousehold_i() {
		return household_i;
	}
	public long getPlug_id() {
		return plug_id;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Out3 [household_i=").append(household_i).append(", plug_id=").append(plug_id).append("]");
		return builder.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (household_i ^ (household_i >>> 32));
		result = prime * result + (int) (plug_id ^ (plug_id >>> 32));
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
		Out3 other = (Out3) obj;
		if (household_i != other.household_i)
			return false;
		if (plug_id != other.plug_id)
			return false;
		return true;
	}
}
