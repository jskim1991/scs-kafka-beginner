package com.nerdybros.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nerdybros.app.producer.NerdyProducer;

@RestController
@SpringBootApplication
public class NerdybrosCourse02Application {

	public static void main(String[] args) {
		SpringApplication.run(NerdybrosCourse02Application.class, args);
	}

	@Autowired
	private NerdyProducer producer;

	@PostMapping(value = "/sendSyncMessage")
	public void sendSyncMessageToKafka(@RequestBody String message) {
		producer.sendSyncMessage(message);
	}

	@PostMapping(value = "/sendAsyncMessage")
	public void sendAsyncMessageToKafka(@RequestBody String message) {
		producer.sendAsyncMessage(message);
	}
}
