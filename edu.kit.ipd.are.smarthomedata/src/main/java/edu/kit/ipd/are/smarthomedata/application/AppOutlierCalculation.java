package edu.kit.ipd.are.smarthomedata.application;

import edu.kit.ipd.are.smarthomedata.analysis.OutlierCalculation;
import edu.kit.ipd.are.smarthomedata.dto.OutlierValue;
import edu.kit.ipd.are.smarthomedata.dto.WindowedValue;

public class AppOutlierCalculation {
	public static void main(String[] args) {
		int window_size = Integer.valueOf(args[0]);
		int window_shift = Integer.valueOf(args[1]);

		System.out.println("Starting " + AppOutlierCalculation.class.getName() + " with window size " + window_size
				+ ", window shift " + window_shift);
		
		CloseableProducer<OutlierValue> outlierProducer = KafkaConnection.getProducerForTopic(Constants.OUTLIERS_TOPIC,
				OutlierValue::serialize);

		OutlierCalculation oc = new OutlierCalculation(outlierProducer);

		KafkaConnection.getConsumerForTopic(Constants.MEDIAN_PER_PLUG_TOPIC, WindowedValue::deserialize, oc);
		KafkaConnection.getConsumerForTopic(Constants.AVERAGE_MEDIAN_ALL_PLUGS_TOPIC, WindowedValue::deserialize, oc);
	}
}