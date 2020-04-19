package com.nerdybros.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping(value = "/sendSyncMessage")
	public void sendSyncMessage(@RequestParam(name = "payload") String payload) {
		producer.sendSyncMessage(payload);
	}

	@GetMapping(value = "/sendAsyncMessage")
	public void sendAsyncMessage(@RequestParam(name = "payload") String payload) {
		producer.sendAsyncMessage(payload);
	}
}
