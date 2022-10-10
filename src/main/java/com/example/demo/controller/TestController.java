package com.example.demo.controller;

import com.example.demo.service.ProducerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;

@RestController
public class TestController {
    private final ProducerService producerService;

    public TestController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping(value = "/send-message")
    public String sendSMSToKafka(@RequestParam("message") String message, @RequestParam("user") Integer user) {
        System.out.println("---------------------------");
        producerService.sendMessage(message, user);
        return "OK";
    }
}
