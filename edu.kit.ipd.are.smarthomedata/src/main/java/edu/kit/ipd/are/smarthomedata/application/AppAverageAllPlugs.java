package edu.kit.ipd.are.smarthomedata.application;

import edu.kit.ipd.are.smarthomedata.analysis.AverageAllPlugs;
import edu.kit.ipd.are.smarthomedata.dto.WindowedMedian;

public class AppAverageAllPlugs {
	public static void main(String[] args) {
		int window_size = Integer.valueOf(args[0]);
		int window_shift = Integer.valueOf(args[1]);

		System.out.println("Starting " + AppAverageAllPlugs.class.getName() + " with window size " + window_size
				+ ", window shift " + window_shift);
		
		CloseableProducer<WindowedMedian> mapProducer = KafkaConnection
				.getProducerForTopic(Constants.MEDIAN_PER_PLUG_TOPIC, WindowedMedian::serialize);
		AverageAllPlugs map = new AverageAllPlugs(mapProducer);

		KafkaConnection.getConsumerForTopic(Constants.MEDIANS_ONE_TOPIC, WindowedMedian::deserialize, map);
	}
}