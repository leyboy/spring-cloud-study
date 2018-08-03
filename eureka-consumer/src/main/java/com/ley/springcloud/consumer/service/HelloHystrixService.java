package com.ley.springcloud.consumer.service;

import com.ley.springcloud.consumer.utils.ServiceInstanceConstants;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("helloHystrixService")
@CommonsLog
public class HelloHystrixService {

    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "helloFallback")
    public String sayHello(){
        log.info("http://"+ ServiceInstanceConstants.SERVICE_INSTANCE_EUREKA_PROVIDER+"/hello");
        return restTemplate.getForEntity("http://"+ ServiceInstanceConstants.SERVICE_INSTANCE_EUREKA_PROVIDER+"/hello",
                String.class).getBody();
    }


    private String helloFallback(){
        return "error";
    }
}
