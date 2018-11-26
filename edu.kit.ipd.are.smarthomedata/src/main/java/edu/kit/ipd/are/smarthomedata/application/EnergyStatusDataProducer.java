package edu.kit.ipd.are.smarthomedata.application;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.KafkaException;

public class EnergyStatusDataProducer {
	private static final String KAFKA_PROPERTIES_PROPERTY_NAME = "kafka.producer.properties";
	private static final String ENERGY_STATUS_DATA_PROPERTY_NAME = "esd.producer.properties";
	private static final String TOPIC_PROPERTY_NAME = "topic";

	public static void main(String[] args) {
		Properties producerProperties = getProperties(KAFKA_PROPERTIES_PROPERTY_NAME);

		Producer<String, String> producer;
		try {
			producer = new KafkaProducer<>(producerProperties);
		} catch (KafkaException e) {
			System.err.println("Error while creating producer from configuration:\n");
			e.printStackTrace();
			throw e;
		}

		Properties esdProperties = getProperties(ENERGY_STATUS_DATA_PROPERTY_NAME);
		String topic = Objects.requireNonNull(esdProperties.getProperty(TOPIC_PROPERTY_NAME),
				ENERGY_STATUS_DATA_PROPERTY_NAME + " does not contain property " + TOPIC_PROPERTY_NAME);

		for (long i = 0; i < Long.MAX_VALUE; i++) {
			System.out.println(Long.toString(i));
			try {
				producer.send(new ProducerRecord<String, String>(topic, Long.toString(i), Long.toString(i))).get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

		producer.close();
	}

	private static Properties getProperties(String propertiesName) {
		String propertiesFileName = System.getProperty(propertiesName);
		if (propertiesFileName == null || propertiesFileName.isEmpty()) {
			throw new IllegalArgumentException("Please set -D" + propertiesName + "=path-to-file.properties");
		}
		Properties props = new Properties();

		try {
			FileInputStream propertiesFile = new FileInputStream(propertiesFileName);
			props.load(propertiesFile);
		} catch (IOException e) {
			System.err.println("Could not load properties from " + propertiesFileName + ".\n");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return props;
	}
}
