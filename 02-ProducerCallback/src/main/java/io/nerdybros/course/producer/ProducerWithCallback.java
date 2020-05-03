package io.nerdybros.course.producer;

import java.util.Map;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;

import io.nerdybros.course.channel.BindingChannels;

@EnableBinding(value = {BindingChannels.class})
public class ProducerWithCallback {

	@Autowired
	private BindingChannels bindingChannels;

	public void sendSyncMessage(String payload) {
		System.out.println("### producer message to broker in sync : " + payload);
		bindingChannels.outputSyncChannel().send(MessageBuilder.withPayload(payload).build());
	}

	public void sendAsyncMessage(String payload) {
		System.out.println("### producer message to broker in async : " + payload);
		bindingChannels.outputAsyncChannel().send(MessageBuilder.withPayload(payload).build());
	}

	public static class CallBackInterceptor implements ProducerInterceptor<byte[], byte[]> {

		@Override
		public void configure(Map<String, ?> configs) {
			System.out.println("### congfiguration");
		}

		@Override
		public ProducerRecord<byte[], byte[]> onSend(ProducerRecord<byte[], byte[]> record) {
			System.out.println("### onSend " + record);
			return record;
		}

		@Override
		public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
			if (metadata != null) {
				System.out.println("### metadata : " + metadata);
			}
			if (exception != null) {
				System.out.println("### exception : " + exception);
			}
		}

		@Override
		public void close() {
			System.out.println("### close");
		}
	}
}
