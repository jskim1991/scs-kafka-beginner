package com.nerdybros.app.consumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.nerdybros.app.channel.BindingChannels;

@Component
@EnableBinding(value = { BindingChannels.class })
public class Consumer {

	@StreamListener(target = BindingChannels.INPUT_CHANNEL)
	public void receiveMessage(@Payload String message) {
		System.out.println("### consumer message from broker : " + message);
	}
}
