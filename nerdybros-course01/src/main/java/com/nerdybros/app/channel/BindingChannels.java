package com.nerdybros.app.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface BindingChannels {

	String INPUT_CHANNEL = "input-channel";

	String OUTPUT_CAHNNEL = "output-channel";

	@Input(INPUT_CHANNEL)
	SubscribableChannel inputChannel();

	@Output(OUTPUT_CAHNNEL)
	MessageChannel outputChannel();
}
