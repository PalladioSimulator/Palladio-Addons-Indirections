package edu.kit.ipd.are.smarthomedata.old;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import edu.kit.ipd.are.smarthomedata.analysis.AverageAllPlugs;
import edu.kit.ipd.are.smarthomedata.analysis.MedianEachPlug;
import edu.kit.ipd.are.smarthomedata.application.CloseableProducer;
import edu.kit.ipd.are.smarthomedata.application.KafkaConnection;
import edu.kit.ipd.are.smarthomedata.dto.SmartMeterReading;
import edu.kit.ipd.are.smarthomedata.dto.SmartMeterReading.ReadingType;
import edu.kit.ipd.are.smarthomedata.dto.WindowedValue;

public class AlterCsvProducer {
	private static final String MEDIAN_ALL_PLUGS_TOPIC = "medianAllPlugs";
	private static final String SMART_METER_READINGS_TOPIC = "readings";
	private static final String MEDIANS_TOPIC = "medians";
//	private static final String IN_FILE = "C:\\work\\docker\\ten_minutes.csv";
//	private static final String IN_FILE = "C:\\work\\docker\\one_hour_mittags.csv";

//	private static final long PLUG_ID = 10L;
//	private static final long HOUSEHOLD_ID = 2L;
	private static final long HOUSE_ID = 7L;
	private static final long HOUSEHOLD_ID = 10L;
	private static final long PLUG_ID = 1L;

	public static void main(String[] args) {
		CloseableProducer<SmartMeterReading> smrProducer = KafkaConnection
				.getProducerForTopic(SMART_METER_READINGS_TOPIC, SmartMeterReading::serialize);

		CloseableProducer<WindowedValue> medianProducer = KafkaConnection.getProducerForTopic(MEDIANS_TOPIC,
				WindowedValue::serialize);
		MedianEachPlug pmp = new MedianEachPlug((it) -> true, 360, 10, medianProducer);

		Closeable smrToPmp = KafkaConnection.getConsumerForTopic(SMART_METER_READINGS_TOPIC,
				SmartMeterReading::deserialize, pmp);

		CloseableProducer<WindowedValue> mapProducer = KafkaConnection.getProducerForTopic(MEDIAN_ALL_PLUGS_TOPIC,
				WindowedValue::serialize);
		AverageAllPlugs map = new AverageAllPlugs(mapProducer);

		Closeable pmpToMap = KafkaConnection.getConsumerForTopic(MEDIANS_TOPIC, WindowedValue::deserialize, map);

		NewAndBrokenOutlierCalculation oc = new NewAndBrokenOutlierCalculation(System.out::println);
		Closeable mapToOc = KafkaConnection.getConsumerForTopic(MEDIAN_ALL_PLUGS_TOPIC, WindowedValue::deserialize,
				oc);
		Closeable pmpToOc = KafkaConnection.getConsumerForTopic(MEDIANS_TOPIC, WindowedValue::deserialize, oc);

//		allCloseables
//				.addAll(Arrays.asList(smrProducer, medianProducer, smrToPmp, mapProducer, pmpToMap, mapToOc, pmpToOc));
//		var eocf = new EmitOnChangeFilter(System.out::println);

		Long timestamp = 0L;
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
				if (smr.timestamp != timestamp) {
//					System.out.println("NEW TIMESTAMP: " + smr.timestamp + " (was " + timestamp + ")");
					timestamp = smr.timestamp;
				}

				smrProducer.accept(smr);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}