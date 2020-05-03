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
	public void receiveEvent01(@Header(KafkaHeaders.RECEIVED_PARTITION_ID) String partition,
			@Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
			@Header(KafkaHeaders.GROUP_ID) String groupId,
			@Payload String payload) {

		System.out.println("### recieve message 01, partition: " + partition + ", topic: " + topic + ", groupId: " + groupId + ", payload: " + payload);

		System.out.println("### start time sleep ###");
		// time delay itentionally to rebalacne partition
		for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
			for (int j = 0; j < 20; j++);
		}
		System.out.println("### end time sleep ###");
	}

	@StreamListener(target = BindingChannels.INPUT_CHANNEL02)
	public void receiveEvent02(@Header(KafkaHeaders.RECEIVED_PARTITION_ID) String partition,
			@Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
			@Header(KafkaHeaders.GROUP_ID) String groupId,
			@Payload String payload) {
		System.out.println("### recieve message 02, partition: " + partition + ", topic: " + topic + ", groupId: " + groupId + ", payload: " + payload);
	}
}
