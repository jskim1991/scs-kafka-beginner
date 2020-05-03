package io.nerdybros.course.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface BindingChannels {

	String INPUT = "input-channel";
	String OUTPUT = "output-channel";
	String IDEMPOTENCE_OUPTUT = "idempotence-output-channel";

	@Input(INPUT)
	SubscribableChannel receiveEvent();

	@Output(OUTPUT)
	MessageChannel sendMessage();

	@Output(IDEMPOTENCE_OUPTUT)
	MessageChannel sendMessageIdempotence();
}
