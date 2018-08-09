package com.ley.springcloud.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@Slf4j
public class HelloController {

    @Value("${from}")
    private String from;

    @Autowired
    private Environment environment;

    @GetMapping("/from")
    public String from(){
        log.info("profile {},name {},uri {}", environment.getProperty("spring.cloud.config.profile"),
                environment.getProperty("spring.application.name"),
                environment.getProperty("spring.cloud.config.uri"));
        log.info(from);
        return from;
    }
}
