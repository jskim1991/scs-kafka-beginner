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

	public void sendMessageWithKey(String key, String payload) {
		// set message key in kafka-header
		Map<String, Object> headersToCopy = new HashMap<>();
		headersToCopy.put(KafkaHeaders.MESSAGE_KEY, key);

		// exception occur, because dosen't have partitionKey
		Message<String> message = MessageBuilder.withPayload(payload).copyHeaders(headersToCopy).build();
		bindingChannels.outputChannel().send(message);
	}

	public void sendMessageWithKeyExpression(String key, String payload) {
		// set message key in kafka-header
		Map<String, Object> headersToCopy = new HashMap<>();
		headersToCopy.put("partitionKey", key);

		Message<String> message = MessageBuilder.withPayload(payload).copyHeaders(headersToCopy).build();
		bindingChannels.outputChannel().send(message);
	}

	public void sendMessageWithKeyExpressionInPayload(String payload) {
		Map<String, Object> headersToCopy = new HashMap<>();
		headersToCopy.put("partitionKey", "tempKey");
		Message<String> message = MessageBuilder.withPayload(payload).copyHeaders(headersToCopy).build();
		bindingChannels.outputChannelPayload().send(message);
	}

}
