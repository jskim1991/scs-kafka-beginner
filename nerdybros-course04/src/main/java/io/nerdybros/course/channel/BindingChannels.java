package io.nerdybros.course.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface BindingChannels {

	String OUTPUT_CHANNEL = "output-channel";
	String OUTPUT_CHANNEL_PAYLOAD = "output-channel-payload";
	String INPUT_CHANNEL01 = "input-channel01";
	String INPUT_CHANNEL02 = "input-channel02";
	String INPUT_CHANNEL03 = "input-channel03";

	@Output(OUTPUT_CHANNEL)
	MessageChannel outputChannel();

	@Output(OUTPUT_CHANNEL_PAYLOAD)
	MessageChannel outputChannelPayload();

	@Input(INPUT_CHANNEL01)
	SubscribableChannel inputChannel01();

	@Input(INPUT_CHANNEL02)
	SubscribableChannel inputChannel02();

	@Input(INPUT_CHANNEL03)
	SubscribableChannel inputChannel03();
}
