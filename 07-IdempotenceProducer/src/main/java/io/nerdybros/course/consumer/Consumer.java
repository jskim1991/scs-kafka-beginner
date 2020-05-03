package io.nerdybros.course.consumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

import io.nerdybros.course.channel.BindingChannels;

@EnableBinding(value = {BindingChannels.class})
public class Consumer {

	@StreamListener(target = BindingChannels.INPUT)
	public void filteredConditionedKafkaHedaer(
			@Header(KafkaHeaders.RECEIVED_PARTITION_ID) String partition,
			@Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
			@Header(KafkaHeaders.GROUP_ID) String groupId,
			@Payload String payload)  {
		System.out.println("### recieve message, partition: " + partition + ", topic: " + topic + ", groupId: "+ groupId + ", payload: " + payload);
	}
}
