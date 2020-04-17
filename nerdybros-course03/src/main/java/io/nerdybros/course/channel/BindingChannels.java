package io.nerdybros.course.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface BindingChannels {

	String OUTPUT_CHANNEL = "output-channel";
	String INPUT_CHANNEL01 = "input-channel01";
	String INPUT_CHANNEL02 = "input-channel02";
	String INPUT_CHANNEL_OTHER = "input-channel-other";

	@Output(OUTPUT_CHANNEL)
	SubscribableChannel outputChannel();

	@Input(INPUT_CHANNEL01)
	SubscribableChannel inputChannel01();

	@Input(INPUT_CHANNEL02)
	SubscribableChannel inputChannel02();

	@Input(INPUT_CHANNEL_OTHER)
	SubscribableChannel inputChannelOther();
}
