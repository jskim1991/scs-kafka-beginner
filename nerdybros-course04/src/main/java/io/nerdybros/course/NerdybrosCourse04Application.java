package io.nerdybros.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.nerdybros.course.producer.Producer;

@RestController
@SpringBootApplication
public class NerdybrosCourse04Application {

	public static void main(String[] args) {
		SpringApplication.run(NerdybrosCourse04Application.class, args);
	}

	@Autowired
	private Producer producer;

	@GetMapping(value = "/send/key-message")
	public void sendMessageWithKey(
			@RequestParam(value = "key") String key,
			@RequestParam(value = "payload") String payload) {
		producer.sendMessageWithKey(key, payload);
	}

	@GetMapping(value = "/send/key-expression-message")
	public void sendMessageWithKeyExpression(
			@RequestParam(value = "key") String key,
			@RequestParam(value = "payload") String payload) {
		producer.sendMessageWithKeyExpression(key, payload);
	}

	@PostMapping(value = "/send/key-expression-message-payload")
	public void sendMessageWithKeyExpressionInPayload(
			@RequestBody String payload) {
		producer.sendMessageWithKeyExpressionInPayload(payload);
	}
}
