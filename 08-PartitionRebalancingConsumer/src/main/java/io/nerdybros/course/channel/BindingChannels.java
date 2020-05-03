package io.nerdybros.course.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface BindingChannels {

	String INPUT_CHANNEL01 = "input-channel01";
	String INPUT_CHANNEL02 = "input-channel02";
	String OUTPUT_CHANNEL = "output-channel";

	@Input(INPUT_CHANNEL01)
	SubscribableChannel receiveEvent01();

	@Input(INPUT_CHANNEL02)
	SubscribableChannel receiveEvent02();

	@Output(OUTPUT_CHANNEL)
	MessageChannel sendMessage();
}
