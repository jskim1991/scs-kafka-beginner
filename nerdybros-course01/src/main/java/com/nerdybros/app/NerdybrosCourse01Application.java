package com.nerdybros.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nerdybros.app.producer.Producer;

@RestController
@SpringBootApplication
public class NerdybrosCourse01Application {

	public static void main(String[] args) {
		SpringApplication.run(NerdybrosCourse01Application.class, args);
	}

	@Autowired
	private Producer producer;

	@GetMapping(value = "/sendMessage")
	public void sendMessageToKafka(@RequestParam(value = "message") String message) {
		producer.sendMessage(message);
	}
}
