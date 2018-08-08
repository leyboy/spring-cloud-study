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

    @Value("${server.address}")
    private String serverAddress;

    @Autowired
    private Environment environment;

    @GetMapping("/serverAddress")
    public String serverAddress(){
        log.info("profile {},name {},uri {}", environment.getProperty("spring.cloud.config.profile"),
                environment.getProperty("spring.application.name"),
                environment.getProperty("spring.cloud.config.uri"));
        return serverAddress;
    }
}
