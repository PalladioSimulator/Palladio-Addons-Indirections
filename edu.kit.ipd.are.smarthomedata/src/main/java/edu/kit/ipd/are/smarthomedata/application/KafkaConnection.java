package edu.kit.ipd.are.smarthomedata.application;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.Function;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.common.KafkaException;

public class KafkaConnection {
	private static final String KAFKA_PROPERTIES_PROPERTY_NAME = "kafka.producer.properties";
	private static final String ENERGY_STATUS_DATA_PROPERTY_NAME = "esd.producer.properties";
	private static final String TOPIC_PROPERTY_NAME = "topic";

//	public static CloseableProducer<String> getProducer() {
//		Properties esdProperties = getProperties(ENERGY_STATUS_DATA_PROPERTY_NAME);
//		String topic = Objects.requireNonNull(esdProperties.getProperty(TOPIC_PROPERTY_NAME),
//				ENERGY_STATUS_DATA_PROPERTY_NAME + " does not contain property " + TOPIC_PROPERTY_NAME);
//
//		return getProducerForTopic(topic);
//	}

	public static CloseableProducer<String> getProducerForTopic(String topic) {
		Producer<String, String> producer = createKafkaProducer();
		return CloseableProducer.fromKafkaProducer(producer, topic);
	}
	
	public static <T> CloseableProducer<T> getProducerForTopic(String topic, Function<T, String> serializer) {
		Producer<String, String> producer = createKafkaProducer();
		return CloseableProducer.fromKafkaProducer(producer, serializer, topic);
	}

	private static Producer<String, String> createKafkaProducer() {
		Properties producerProperties = getProperties(KAFKA_PROPERTIES_PROPERTY_NAME);

		Producer<String, String> producer;
		try {
			producer = new KafkaProducer<>(producerProperties);
		} catch (KafkaException e) {
			System.err.println("Error while creating producer from configuration:\n");
			e.printStackTrace();
			throw e;
		}
		return producer;
	}
	

//	public static Closeable getConsumer(Consumer<String> callback) {
//		Properties esdProperties = getProperties(ENERGY_STATUS_DATA_PROPERTY_NAME);
//		String topic = Objects.requireNonNull(esdProperties.getProperty(TOPIC_PROPERTY_NAME),
//				ENERGY_STATUS_DATA_PROPERTY_NAME + " does not contain property " + TOPIC_PROPERTY_NAME);
//
//		return getConsumerForTopic(topic, callback);
//	}

	public static Closeable getConsumerForTopic(String topic, Consumer<String> callback) {
		System.out.println("Creating consumer for topic " + topic);
		Properties consumerProperties = getProperties(KAFKA_PROPERTIES_PROPERTY_NAME);

		KafkaConsumer<String, String> consumer;
		try {
			consumer = new KafkaConsumer<>(consumerProperties);
		} catch (KafkaException e) {
			System.err.println("Error while creating producer from configuration:\n");
			e.printStackTrace();
			throw e;
		}

		return fromKafkaConsumer(consumer, topic, callback);
	}
	
	public static <T> Closeable getConsumerForTopic(String topic, Function<String, T> deserializer, Consumer<T> callback) {
		return getConsumerForTopic(topic, it -> callback.accept(deserializer.apply(it)));
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

	public static Closeable fromKafkaConsumer(org.apache.kafka.clients.consumer.Consumer<String, String> consumer,
			String topic, java.util.function.Consumer<String> callback) {
		consumer.subscribe(Collections.singleton(topic));
		final var t = new Thread(() -> {
			while (!Thread.interrupted()) {
				ConsumerRecords<String, String> poll = consumer.poll(Duration.ofSeconds(20));
				if (poll.count() == 0) {
					System.out.println("Warning, no records found for " + topic + ".");
				} else {
					poll.records(topic).forEach(record -> {
//						System.out.printf("%s/%s: Consumer Record:(%d, (%s), %d, %d)\n",
//		                        topic, record.topic(), record.key(), record.value(),
//		                        record.partition(), record.offset());
						callback.accept(record.value());
					});
					consumer.commitAsync();
				}
			}
		});
		
		t.start();

		return new Closeable() {
			@Override
			public void close() throws IOException {
				System.out.println("Closing consumer for topic " + topic);
				t.interrupt();
				consumer.close();
			}
		};
	}
}
