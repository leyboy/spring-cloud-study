package com.ley.springcloud.bus.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HelloListener implements ApplicationListener<HelloEvent> {

    @Override
    public void onApplicationEvent(HelloEvent event) {
        log.info("timestamp:{},source:{},hello:{}",
                event.getTimestamp(),event.getSource(),event.getHello());
    }
}
