package com.example.demo.service;

import com.example.demo.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public ProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String smsJsonData, Integer user) {
        if (user == 1) {
            this.kafkaTemplate.send(Constant.KAFKA.TOPIC_A_SEND_MESSAGE, smsJsonData);
        } else {
            this.kafkaTemplate.send(Constant.KAFKA.TOPIC_B_SEND_MESSAGE, smsJsonData);
        }

    }
}