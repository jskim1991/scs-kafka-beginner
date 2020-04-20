package io.nerdybros.course.consumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

import io.nerdybros.course.channel.BindingChannels;

@EnableBinding(value = { BindingChannels.class })
public class Consumer {

	// error channel naming rule : #{topic}.#{groupName}.errors
	@ServiceActivator(inputChannel = "nerdy-bros-partition.group01.errors")
	public void errorChannelFst(Message<String> message) {
	    System.out.println("Handling ERROR: " + message);
	}

	@StreamListener(target = BindingChannels.INPUT_CHANNEL01)
	public void receiveMessage01(
			@Header(KafkaHeaders.RECEIVED_PARTITION_ID) String partition,
			@Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
			@Header(KafkaHeaders.GROUP_ID) String groupId,
			@Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String messageKey,
			@Payload String payload) {
		System.out.println("### recieve message 01, partition: " + partition + ", topic: " + topic + ", groupId: "+ groupId + ", meesageKey: " + messageKey + ", payload: " + payload);
	}

	@StreamListener(target = BindingChannels.INPUT_CHANNEL02)
	public void receiveMessage02(
			@Header(KafkaHeaders.RECEIVED_PARTITION_ID) String partition,
			@Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
			@Header(KafkaHeaders.GROUP_ID) String groupId,
			@Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String messageKey,
			@Payload String payload) {
		System.out.println("### recieve message 02, partition: " + partition + ", topic: " + topic + ", groupId: "+ groupId + ", meesageKey: " + messageKey + ", payload: " + payload);
	}

	@StreamListener(target = BindingChannels.INPUT_CHANNEL_OTHER)
	public void receiveMessageOther(
			@Header(KafkaHeaders.RECEIVED_PARTITION_ID) String partition,
			@Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
			@Header(KafkaHeaders.GROUP_ID) String groupId,
			@Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String messageKey,
			@Payload String payload) {
		System.out.println("### recieve message other, partition: " + partition + ", topic: " + topic + ", groupId: "+ groupId + ", meesageKey: " + messageKey + ", payload: " + payload);
	}
}
