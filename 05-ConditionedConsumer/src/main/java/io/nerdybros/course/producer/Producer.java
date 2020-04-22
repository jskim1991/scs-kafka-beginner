package io.nerdybros.course.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;

import io.nerdybros.course.channels.BindingChannels;

@EnableBinding(value = { BindingChannels.class })
public class Producer {

	@Autowired
	private BindingChannels bindingChannels;

	public void sendMessage(String key, String message) {
		System.out.println("### producer message to broker : " + message);
		bindingChannels.outputChannel().send(MessageBuilder.withPayload(message).setHeader("status", key).build());
	}
}
