package com.ley.springcloud.feign.consumer.controller;

import com.ley.springcloud.feign.consumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/feign-consumer")
    public String hello(){
        return helloService.sayHello();
    }
}
