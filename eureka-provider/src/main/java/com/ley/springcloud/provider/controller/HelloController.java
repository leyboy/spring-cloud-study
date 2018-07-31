package com.ley.springcloud.provider.controller;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CommonsLog
public class HelloController {

    public static final String HELLO_WORLD = "Hello World!";

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/hello")
    public String index() {
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        log.info("/hello,host" + serviceInstance.getHost() + ",service_id: " +
                serviceInstance.getServiceId());
        return HELLO_WORLD;
    }
}
