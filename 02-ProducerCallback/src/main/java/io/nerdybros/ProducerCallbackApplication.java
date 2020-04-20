package io.nerdybros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.nerdybros.producer.ProducerWithCallback;

@RestController
@SpringBootApplication
public class ProducerCallbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerCallbackApplication.class, args);
	}

	@Autowired
	private ProducerWithCallback producer;

	@GetMapping(value = "/sendSyncMessage")
	public void sendSyncMessage(@RequestParam(name = "payload") String payload) {
		producer.sendSyncMessage(payload);
	}

	@GetMapping(value = "/sendAsyncMessage")
	public void sendAsyncMessage(@RequestParam(name = "payload") String payload) {
		producer.sendAsyncMessage(payload);
	}
}
