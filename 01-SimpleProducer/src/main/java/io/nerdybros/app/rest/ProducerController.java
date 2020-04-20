package io.nerdybros.app.rest;

import io.nerdybros.app.producer.SimpleProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("producer")
public class ProducerController {

    @Autowired
    private SimpleProducer simpleProducer;

    @GetMapping(value = "/sendMessage")
    public void sendMessageToKafka(@RequestParam(value = "message") String message) {
        this.simpleProducer.sendMessage(message);
    }
}
