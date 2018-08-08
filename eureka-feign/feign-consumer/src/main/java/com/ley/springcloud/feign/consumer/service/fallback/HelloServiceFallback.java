package com.ley.springcloud.feign.consumer.service.fallback;

import com.ley.springcloud.feign.consumer.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HelloServiceFallback implements HelloService{

    @Override
    public String sayHello() {
        log.info("service {},method {},服务降级逻辑",HelloService.class.getName()
            ,"sayHello");
        return "error";
    }
}
