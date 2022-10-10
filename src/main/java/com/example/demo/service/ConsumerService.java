package com.example.demo.service;

import com.example.demo.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerService {
    @KafkaListener(topics = Constant.KAFKA.TOPIC_A_SEND_MESSAGE, groupId = Constant.KAFKA.GROUP_ID)
    public void consumeA(String jsonData) {
        log.info(String.format("User B: message-> %s", jsonData));
    }

    @KafkaListener(topics = Constant.KAFKA.TOPIC_B_SEND_MESSAGE, groupId = Constant.KAFKA.GROUP_ID)
    public void consumeB(String jsonData) {
        log.info(String.format("User A: message-> %s", jsonData));
    }
}
