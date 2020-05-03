package io.nerdybros.course.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;

import io.nerdybros.course.channel.BindingChannels;

@EnableBinding(value = { BindingChannels.class })
public class Producer {

	@Autowired
	private BindingChannels channelBindings;

	public void sendMessage(String payload) {
		channelBindings.sendMessage().send(MessageBuilder.withPayload(payload).build());
	}

	public void sendMessageTransactional(String payload) {
		channelBindings.sendMessageIdempotence().send(MessageBuilder.withPayload(payload).build());
	}
}
