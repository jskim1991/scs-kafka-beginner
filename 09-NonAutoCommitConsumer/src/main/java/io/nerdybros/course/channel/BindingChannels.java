package io.nerdybros.course.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface BindingChannels {

	String AUTO_COMMIT_INPUT_CHANNEL = "auto-commit-input-channel";
	String NON_AUTO_COMMIT_INPUT_CHANNEL = "non-auto-commit-input-channel";
	String OUTPUT_CHANNEL = "output-channel";

	@Input(AUTO_COMMIT_INPUT_CHANNEL)
	SubscribableChannel receiveEventAutoCommit();

	@Input(NON_AUTO_COMMIT_INPUT_CHANNEL)
	SubscribableChannel receiveEventNonAutoCommit();

	@Output(OUTPUT_CHANNEL)
	MessageChannel sendMessage();
}
