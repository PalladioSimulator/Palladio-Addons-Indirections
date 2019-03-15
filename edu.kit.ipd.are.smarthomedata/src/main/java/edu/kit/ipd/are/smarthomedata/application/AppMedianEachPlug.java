package edu.kit.ipd.are.smarthomedata.application;

import edu.kit.ipd.are.smarthomedata.analysis.MedianEachPlug;
import edu.kit.ipd.are.smarthomedata.dto.SmartMeterReading;
import edu.kit.ipd.are.smarthomedata.dto.WindowedValue;

public class AppMedianEachPlug {
	public static void main(String[] args) {
		int window_size = Integer.valueOf(args[0]);
		int window_shift = Integer.valueOf(args[1]);

		System.out.println("Starting " + AppMedianEachPlug.class.getName() + " with window size " + window_size
				+ ", window shift " + window_shift);

		CloseableProducer<WindowedValue> medianOneProducer = KafkaConnection
				.getProducerForTopic(Constants.MEDIAN_PER_PLUG_TOPIC, WindowedValue::serialize);

		MedianEachPlug pmp = new MedianEachPlug((it) -> true, window_size, window_shift, medianOneProducer);

		KafkaConnection.getConsumerForTopic(Constants.SMART_METER_READINGS_TOPIC, SmartMeterReading::deserialize, pmp);
	}
}