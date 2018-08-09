package com.ley.springcloud.bus.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
@Slf4j
public class Receiver {

    @RabbitHandler
    public void handler(String hello) {
        System.out.println("Receiver: " + hello);
    }
}
