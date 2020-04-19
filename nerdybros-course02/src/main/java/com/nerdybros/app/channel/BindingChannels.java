package com.nerdybros.app.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface BindingChannels {

	String OUTPUT_SYNC_CHANNEL = "output-sync-channel";
	String OUTPUT_ASYNC_CHANNEL = "output-async-channel";

	String INPUT_CHANNEL = "input-channel";

	@Output(OUTPUT_SYNC_CHANNEL)
	MessageChannel outputSyncChannel();

	@Output(OUTPUT_ASYNC_CHANNEL)
	MessageChannel outputAsyncChannel();

	@Input(INPUT_CHANNEL)
	SubscribableChannel inputChannel();
}
