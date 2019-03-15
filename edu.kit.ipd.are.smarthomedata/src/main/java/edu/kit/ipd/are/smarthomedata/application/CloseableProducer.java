package edu.kit.ipd.are.smarthomedata.application;

import java.io.Closeable;
import java.util.function.Consumer;
import java.util.function.Function;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public interface CloseableProducer<T> extends Consumer<T>, Closeable {
	public static CloseableProducer<String> fromKafkaProducer(final Producer<String, String> producer, String topic) {
		return new CloseableProducer<String>() {
			@Override
			public void accept(String message) {
				producer.send(new ProducerRecord<String, String>(topic, message));
			}

			@Override
			public void close() {
				producer.close();
			}
		};
	}
	
	public static <T> CloseableProducer<T> fromKafkaProducer(final Producer<String, String> producer, final Function<T, String> serializer, String topic) {
		return new CloseableProducer<T>() {
			long messageCount = 0L;
			
			@Override
			public void accept(T message) {
				messageCount++;
				if (messageCount % 10000L == 0) {
					System.out.println("" + messageCount + " messages delivered to " + topic);
				}
				producer.send(new ProducerRecord<String, String>(topic, serializer.apply(message)));
			}

			@Override
			public void close() {
				producer.close();
			}
		};
	}
}
