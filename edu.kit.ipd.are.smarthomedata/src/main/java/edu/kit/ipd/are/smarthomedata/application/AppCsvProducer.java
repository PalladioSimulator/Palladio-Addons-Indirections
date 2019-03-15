package edu.kit.ipd.are.smarthomedata.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import edu.kit.ipd.are.smarthomedata.dto.PlugIdentifier;
import edu.kit.ipd.are.smarthomedata.dto.SmartMeterReading;
import edu.kit.ipd.are.smarthomedata.dto.SmartMeterReading.ReadingType;

// CSV --> t: readings
public class AppCsvProducer {
	private static Map<PlugIdentifier, Double> lastValue = new HashMap<>();
	private static Set<PlugIdentifier> emitted = new HashSet<>();
	private static CloseableProducer<SmartMeterReading> smrProducer;

	public static int duplication;
	public static int maxHouses;

	public final static int MAX_HOUSE_NUMBER = 100;
	private static long startTime;
	private static long lastTimestamp;

	public static void main(String[] args) {
		System.out.println("Starting CsvProducer");
		smrProducer = KafkaConnection.getProducerForTopic(Constants.SMART_METER_READINGS_TOPIC,
				SmartMeterReading::serialize);

		duplication = Integer.valueOf(args[1]);
		maxHouses = Integer.valueOf(args[2]);

		startTime = System.currentTimeMillis() / 1000L;
		lastTimestamp = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.equals("id,timestamp,value,property,plug_id,household_id,house_id")) {
					continue;
				}

				SmartMeterReading smr = SmartMeterReading.fromCsvString(line);
				if (smr.property != ReadingType.LOAD) {
					continue;
				}

				if (smr.house_id > maxHouses) {
					continue;
				}

				if (smr.timestamp < lastTimestamp) {
					throw new IllegalStateException("Timestamps not ordered.");
				}

				for (int i = 0; i < duplication; i++) {
					SmartMeterReading reading = new SmartMeterReading(smr.id, smr.timestamp, smr.value, smr.property,
							smr.plug_id, smr.household_id, smr.house_id + i * MAX_HOUSE_NUMBER, System.currentTimeMillis());

					handleReading(reading);
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private static void handleReading(SmartMeterReading smr) throws InterruptedException {
		// output value for all plugs for which no value exists for this timestamp
		if (smr.timestamp > lastTimestamp) {
			for (long ts = lastTimestamp; ts < smr.timestamp; ts++) {
				boolean out = false;
				while ((System.currentTimeMillis() / 1000L) - startTime < ts) {
					long waitFor = 1000L * (ts + startTime) - System.currentTimeMillis();
					if (waitFor > 0) {
						if (!out) {
							System.out.println("Waiting until " + ts + " (for " + waitFor + " ms). Now: "
									+ ((System.currentTimeMillis() / 1000L) - startTime));
							out = true;
						}
						Thread.sleep(waitFor);
					}
				}

				for (var entry : lastValue.entrySet()) {
					PlugIdentifier pi = entry.getKey();
					if (!emitted.contains(pi)) {
						emit(new SmartMeterReading(-1, ts, entry.getValue(), SmartMeterReading.ReadingType.LOAD,
								pi.plugId, pi.householdId, pi.houseId, System.currentTimeMillis()));
					}
				}
				emitted = new HashSet<>();
			}
		}

		lastTimestamp = smr.timestamp;
		emit(smr);
	}

	private static void emit(SmartMeterReading reading) {
		emitted.add(reading.plugIdentifier);
		lastValue.put(reading.plugIdentifier, reading.value);
		smrProducer.accept(reading);
	}
}