package io.nerdybros.course.producer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import io.nerdybros.course.channel.BindingChannels;

@EnableBinding(value = { BindingChannels.class })
public class Producer {

	@Autowired
	private BindingChannels bindingChannels;

	public void sendMessage(String payload) {
		// just send message
		Message<String> message = MessageBuilder.withPayload(payload).build();
		bindingChannels.outputChannel().send(message);
	}

	public void sendMessageWithKey(String key, String payload) {

		// set message key in kafka-header
		Map<String, Object> headersToCopy = new HashMap<>();
		headersToCopy.put(KafkaHeaders.MESSAGE_KEY, key);

		Message<String> message = MessageBuilder.withPayload(payload).copyHeaders(headersToCopy).build();

		bindingChannels.outputChannel().send(message);
	}

	public void sendMessageWithKeyOverridePartition(String key, String payload) {

		// override partition to fix partition in kafka-header
		Map<String, Object> headersToCopy = new HashMap<>();
		headersToCopy.put(KafkaHeaders.MESSAGE_KEY, key);
		headersToCopy.put(KafkaHeaders.PARTITION_ID, 1);

		Message<String> message = MessageBuilder.withPayload(payload).copyHeaders(headersToCopy).build();

		bindingChannels.outputChannel().send(message);
	}
}
