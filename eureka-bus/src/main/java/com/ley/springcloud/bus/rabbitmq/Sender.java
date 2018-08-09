package com.ley.springcloud.bus.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;


    public void send() {
        String context = "Hello: " + new Date(System.currentTimeMillis());
        log.info("Sender: {}", context);
        amqpTemplate.convertAndSend("hello", context);
    }
}
