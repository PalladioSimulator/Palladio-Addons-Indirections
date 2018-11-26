package edu.kit.ipd.are.smarthomedata.dto;

import java.util.Objects;

public class SmartMeterReading {
	public enum ReadingType {
		WORK, LOAD
	}

	public final long id;
	public final long timestamp;
	public final float value;
	public final ReadingType property;
	public final long plug_id;
	public final long household_id;
	public final long house_id;
	
	public final PlugIdentifier plugIdentifier;
	
	public static final long START = 1378027841L;//1377986401L;

	public SmartMeterReading(long id, long timestamp, float value, ReadingType property, long plug_id, long household_id,
			long house_id) {
		this.id = id;
		this.timestamp = timestamp;
		this.value = value;
		this.property = property;
		this.plug_id = plug_id;
		this.household_id = household_id;
		this.house_id = house_id;
		
		this.plugIdentifier = new PlugIdentifier(plug_id, household_id, house_id);
	}

	/**
	 * The schema of the base stream is following:
	 * 
	 * id – a unique identifier of the measurement [32 bit unsigned integer value]
	 * 
	 * timestamp - timestamp of measurement (number of seconds since January 1,
	 * 1970, 00:00:00 GMT) [32 bit unsigned integer value]
	 * 
	 * value – the measurement [32 bit floating point]
	 * 
	 * property – type of the measurement: 0 for work or 1 for load [boolean]
	 * 
	 * plug_id – a unique identifier (within a household) of the smart plug [32 bit
	 * unsigned integer value]
	 * 
	 * household_id – a unique identifier of a household (within a house) where the
	 * plug is located [32 bit unsigned integer value]
	 * 
	 * house_id – a unique identifier of a house where the household with the plug
	 * is located [32 bit unsigned integer value]
	 * 
	 * @param csvLine
	 * @return
	 */
	public static SmartMeterReading fromCsvString(String csvLine) {
		String[] fields = csvLine.split(",");

		long id = Long.valueOf(fields[0]);
		long timestamp = Long.valueOf(fields[1]) - START;
		float value = Float.valueOf(fields[2]);
		ReadingType property = fields[3].equals("0") ? ReadingType.WORK : (fields[3].equals("1") ? ReadingType.LOAD : null);
		Objects.requireNonNull(property);
		long plug_id = Integer.valueOf(fields[4]);
		long household_id = Integer.valueOf(fields[5]);
		long house_id = Integer.valueOf(fields[6]);

		SmartMeterReading smartMeterReading = new SmartMeterReading(id, timestamp, value, property, plug_id, household_id, house_id);
		return smartMeterReading;
	}

	@Override
	public String toString() {
		return "(id=" + id + ", ts=" + timestamp + ", v=" + value + ", p="
				+ property + ", " + plugIdentifier + ")";
	}
	
	
}