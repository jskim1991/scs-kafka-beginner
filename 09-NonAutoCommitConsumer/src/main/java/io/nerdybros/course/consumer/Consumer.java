package io.nerdybros.course.consumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

import io.nerdybros.course.channel.BindingChannels;

@EnableBinding(value = { BindingChannels.class })
public class Consumer {

	@StreamListener(target = BindingChannels.AUTO_COMMIT_INPUT_CHANNEL)
	public void receiveEventAutoCommit(@Header(KafkaHeaders.RECEIVED_PARTITION_ID) String partition,
			@Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
			@Header(KafkaHeaders.GROUP_ID) String groupId,
			@Payload String payload) {
		// you can see offset info of partition by using this cli: kafka-consumer-groups.bat --bootstrap-server localhost:9092 --group autoCommitGroup --describe
		System.out.println("### recieve message auto commit, partition: " + partition + ", topic: " + topic + ", groupId: " + groupId + ", payload: " + payload);
	}

	@StreamListener(target = BindingChannels.NON_AUTO_COMMIT_INPUT_CHANNEL)
	public void receiveEventNonAutoCommit(@Header(KafkaHeaders.RECEIVED_PARTITION_ID) String partition,
			@Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
			@Header(KafkaHeaders.GROUP_ID) String groupId,
			@Header(KafkaHeaders.ACKNOWLEDGMENT) Acknowledgment acknowledgment,
			@Payload String payload) {
		// you can see offset info of partition by using this cli: kafka-consumer-groups.bat --bootstrap-server localhost:9092 --group nonAutoCommitGroup --describe
		System.out.println("### recieve message none auto commit, partition: " + partition + ", topic: " + topic + ", groupId: " + groupId + ", payload: " + payload + ", acknowledgment: " + acknowledgment);
		// remove comment(//) from under code, you can commit manually
		acknowledgment.acknowledge();
	}
}
