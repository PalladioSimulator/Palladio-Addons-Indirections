package edu.kit.ipd.are.smarthomedata.application;

import edu.kit.ipd.are.smarthomedata.analysis.AverageAllPlugs;
import edu.kit.ipd.are.smarthomedata.dto.WindowedValue;

public class AppAverageAllPlugs {
	public static void main(String[] args) {
		int window_size = Integer.valueOf(args[0]);
		int window_shift = Integer.valueOf(args[1]);

		System.out.println("Starting " + AppAverageAllPlugs.class.getName() + " with window size " + window_size
				+ ", window shift " + window_shift);

		CloseableProducer<WindowedValue> mapProducer = KafkaConnection
				.getProducerForTopic(Constants.AVERAGE_MEDIAN_ALL_PLUGS_TOPIC, WindowedValue::serialize);
		AverageAllPlugs map = new AverageAllPlugs(mapProducer);

		KafkaConnection.getConsumerForTopic(Constants.MEDIAN_PER_PLUG_TOPIC, WindowedValue::deserialize, map);
	}
}