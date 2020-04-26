package io.nerdybros.course.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ChannelBindings {

	String OUTPUT = "output-channel";
	String IDEMPOTENT_OUPTUT = "idemptent-output-channel";

	@Output(OUTPUT)
	MessageChannel sendMessage();

	@Output(IDEMPOTENT_OUPTUT)
	MessageChannel sendMessageIdempotent();
}
