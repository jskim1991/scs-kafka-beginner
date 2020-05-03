package io.nerdybros.course.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface BindingChannels {

	String OUTPUT_SYNC_CHANNEL = "output-sync-channel";
	String OUTPUT_ASYNC_CHANNEL = "output-async-channel";

	@Output(OUTPUT_SYNC_CHANNEL)
	MessageChannel outputSyncChannel();

	@Output(OUTPUT_ASYNC_CHANNEL)
	MessageChannel outputAsyncChannel();
}
