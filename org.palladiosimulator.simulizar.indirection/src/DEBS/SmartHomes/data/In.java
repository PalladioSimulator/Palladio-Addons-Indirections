package DEBS.SmartHomes.data;

public class In {
	private long id;
	private long timestamp;
	private float value;
	private boolean property; 
	private long plug_id;
	private long household_id;
	private long house_id;
	
	public In(long id, long timestamp, float value, boolean property, long plug_id, long household_id, long house_id) {
		this.id = id;
		this.timestamp = timestamp;
		this.value = value;
		this.property = property;
		this.plug_id = plug_id;
		this.household_id = household_id;
		this.house_id = house_id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public boolean isProperty() {
		return property;
	}

	public void setProperty(boolean property) {
		this.property = property;
	}

	public long getPlug_id() {
		return plug_id;
	}

	public void setPlug_id(long plug_id) {
		this.plug_id = plug_id;
	}

	public long getHousehold_id() {
		return household_id;
	}

	public void setHousehold_id(long household_id) {
		this.household_id = household_id;
	}

	public long getHouse_id() {
		return house_id;
	}

	public void setHouse_id(long house_id) {
		this.house_id = house_id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("In [id=").append(id).append(", timestamp=").append(timestamp).append(", value=").append(value)
				.append(", property=").append(property).append(", plug_id=").append(plug_id).append(", household_id=")
				.append(household_id).append(", house_id=").append(house_id).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (house_id ^ (house_id >>> 32));
		result = prime * result + (int) (household_id ^ (household_id >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (plug_id ^ (plug_id >>> 32));
		result = prime * result + (property ? 1231 : 1237);
		result = prime * result + (int) (timestamp ^ (timestamp >>> 32));
		result = prime * result + Float.floatToIntBits(value);
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
		In other = (In) obj;
		if (house_id != other.house_id)
			return false;
		if (household_id != other.household_id)
			return false;
		if (id != other.id)
			return false;
		if (plug_id != other.plug_id)
			return false;
		if (property != other.property)
			return false;
		if (timestamp != other.timestamp)
			return false;
		if (Float.floatToIntBits(value) != Float.floatToIntBits(other.value))
			return false;
		return true;
	}
	
	
}
