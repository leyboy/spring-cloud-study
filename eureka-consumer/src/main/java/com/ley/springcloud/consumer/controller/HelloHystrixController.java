package com.ley.springcloud.consumer.controller;

import com.ley.springcloud.consumer.service.HelloHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHystrixController {

    @Autowired
    @Qualifier(value = "helloHystrixService")
    private HelloHystrixService helloHystrixService;

    @GetMapping(value = "/ribbon-hystrix-consumer")
    public String hello(){
        return helloHystrixService.sayHello();
    }
}
