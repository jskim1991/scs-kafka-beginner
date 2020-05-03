package io.nerdybros.course.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;

@EnableBinding(value = { SourceBinding.class })
public class SimpleProducer {

	@Autowired
	private SourceBinding bindingChannels;

	public void sendMessage(String message) {
		System.out.println("### producer message to broker : " + message);
		bindingChannels.outputChannel().send(MessageBuilder.withPayload(message).build());
	}
}
