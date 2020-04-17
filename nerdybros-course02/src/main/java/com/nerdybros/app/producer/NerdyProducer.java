package com.nerdybros.app.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class NerdyProducer {

	public static Properties init() {
		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		return props;
	}

	public void sendSyncMessage(String message) {

		long start = System.currentTimeMillis();

		System.out.println("### producer message to broker in sync : " + message);

		try (Producer<String, String> producer = new KafkaProducer<>(NerdyProducer.init())) {
			// channelName & message
			ProducerRecord<String, String> record = new ProducerRecord<>("nerdy-bros", "### producer send message : " + message);
			RecordMetadata recordMetadata = producer.send(record).get();
			if (!ObjectUtils.isEmpty(recordMetadata)) {
				// topic-partition@offset
				System.out.println(recordMetadata);
			}
		} catch (Exception e) {
			System.out.println("### sendMessage Exception message : " + e.getMessage());
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();
		System.out.println("### sync message send - during time : " + (end - start));
	}

	public void sendAsyncMessage(String message) {

		long start = System.currentTimeMillis();

		System.out.println("### producer message to broker in async : " + message);

		try (Producer<String, String> producer = new KafkaProducer<>(NerdyProducer.init())) {
			// channelName & message
			ProducerRecord<String, String> record = new ProducerRecord<>("nerdy-bros", "### producer send message : " + message);
			producer.send(record, new Callback() {
				@Override
				public void onCompletion(RecordMetadata metadata, Exception exception) {
					if (!ObjectUtils.isEmpty(metadata)) {
						// topic-partition@offset
						System.out.println(metadata);
					} else {
						exception.printStackTrace();
						throw new RuntimeException(exception);
					}
				}
			});
		} catch (Exception e) {
			System.out.println("### sendMessage Exception message : " + e.getMessage());
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();
		System.out.println("### async message send - during time : " + (end - start));
	}
}
