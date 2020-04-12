package com.nerdybros.app.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.nerdybros.app.channel.BindingChannels;

@Component
@EnableBinding(value = { BindingChannels.class })
public class Producer {

	@Autowired
	private BindingChannels bindingChannels;

	public void sendMessage(String message) {
		System.out.println("### producer message to broker : " + message);
		bindingChannels.outputChannel().send(MessageBuilder.withPayload(message).build());
	}

}
