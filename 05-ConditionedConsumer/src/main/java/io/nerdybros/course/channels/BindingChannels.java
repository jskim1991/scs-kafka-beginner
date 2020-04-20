package io.nerdybros.course.channels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface BindingChannels {

	String INPUT_CHANNEL01 = "input-channel01";
	String INPUT_CHANNEL02 = "input-channel02";

	@Input(INPUT_CHANNEL01)
	SubscribableChannel inputChannle01();

	@Input(INPUT_CHANNEL02)
	SubscribableChannel inputChannle02();
}
