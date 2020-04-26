package io.nerdybros.course.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;

import io.nerdybros.course.channel.ChannelBindings;

@EnableBinding(value = { ChannelBindings.class })
public class Producer {

	@Autowired
	private ChannelBindings channelBindings;

	public void sendMessage(String payload) {
		channelBindings.sendMessage().send(MessageBuilder.withPayload(payload).build());
	}

	public void sendMessageIdempotent(String payload) {
		channelBindings.sendMessageIdempotent().send(MessageBuilder.withPayload(payload).build());
	}
}
