package io.nerdybros.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.nerdybros.course.producer.Producer;

@RestController
@SpringBootApplication
public class PartitionedProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartitionedProducerApplication.class, args);
	}

	@Autowired
	private Producer producer;

	@GetMapping(value = "/send/message")
	public void sendMessage(@RequestParam(value = "payload") String payload) {
		producer.sendMessage(payload);
	}

	@GetMapping(value = "/send/key-message")
	public void sendMessageWithKey(
			@RequestParam(value = "key") String key,
			@RequestParam(value = "payload") String payload) {
		producer.sendMessageWithKey(key, payload);
	}

	@GetMapping(value = "/send/key-message-override")
	public void sendMessageWithKeyOverridePartition(
			@RequestParam(value = "key") String key,
			@RequestParam(value = "payload") String payload) {
		producer.sendMessageWithKeyOverridePartition(key, payload);
	}

}
