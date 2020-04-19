package com.nerdybros.app.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface BindingChannels {

	String INPUT_CHANNEL = "input-channel";
	String OUTPUT_CHANNEL = "output-channel";

	@Input(INPUT_CHANNEL)
	SubscribableChannel inputChannel();
	@Input(INPUT_CHANNEL)
	SubscribableChannel outputChannel();
}
