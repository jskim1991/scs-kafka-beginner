package io.nerdybros.course.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface SourceBinding {

	String OUTPUT_CHANNEL = "output-channel";

	@Output(OUTPUT_CHANNEL)
	MessageChannel outputChannel();
}
