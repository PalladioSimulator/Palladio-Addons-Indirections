package edu.kit.ipd.are.smarthomedata.application;

import edu.kit.ipd.are.smarthomedata.analysis.MedianEachPlug;
import edu.kit.ipd.are.smarthomedata.dto.SmartMeterReading;
import edu.kit.ipd.are.smarthomedata.dto.WindowedMedian;

public class AppMedianEachPlug {
	public static void main(String[] args) {
		int window_size = Integer.valueOf(args[0]);
		int window_shift = Integer.valueOf(args[1]);

		System.out.println("Starting " + AppMedianEachPlug.class.getName() + " with window size " + window_size
				+ ", window shift " + window_shift);

		CloseableProducer<WindowedMedian> medianOneProducer = KafkaConnection
				.getProducerForTopic(Constants.MEDIANS_ONE_TOPIC, WindowedMedian::serialize);
		/*
		 * CloseableProducer<WindowedMedian> medianTwoProducer = KafkaConnection
		 * .getProducerForTopic(Constants.MEDIANS_TWO_TOPIC, WindowedMedian::serialize);
		 */
		MedianEachPlug pmp = new MedianEachPlug((it) -> true, window_size, window_shift,
				// medianOneProducer.andThen(medianTwoProducer));
				medianOneProducer);

		KafkaConnection.getConsumerForTopic(Constants.SMART_METER_READINGS_TOPIC, SmartMeterReading::deserialize, pmp);
	}
}