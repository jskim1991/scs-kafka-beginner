package io.nerdybros.course.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ChannelBindings {

	String OUTPUT = "output-channel";
	String EXACTLY_OUPTUT = "exactly-once-output-channel";

	@Output(OUTPUT)
	MessageChannel sendMessage();

	@Output(EXACTLY_OUPTUT)
	MessageChannel sendMessageExactlyOnce();
}
