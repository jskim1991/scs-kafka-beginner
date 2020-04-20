package io.nerdybros.course.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface BindingChannels {

	String OUTPUT_CHANNEL = "output-channel";

	@Output(OUTPUT_CHANNEL)
	MessageChannel outputChannel();
}
