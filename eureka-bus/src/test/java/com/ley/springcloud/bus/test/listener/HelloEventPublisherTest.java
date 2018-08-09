package com.ley.springcloud.bus.test.listener;

import com.ley.springcloud.bus.event.HelloEvent;
import com.ley.springcloud.bus.event.HelloListener;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@ComponentScan("com.ley.springcloud.bus.event")
@SpringBootTest
@RunWith(SpringRunner.class)
public class HelloEventPublisherTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testHelloEventPublisher(){
        System.out.println(applicationContext.getBean(HelloListener.class));
        applicationContext.publishEvent(new HelloEvent(UUID.randomUUID(),"Hello"));
    }
}
