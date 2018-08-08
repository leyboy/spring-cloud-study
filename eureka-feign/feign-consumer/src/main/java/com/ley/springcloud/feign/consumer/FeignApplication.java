package com.ley.springcloud.feign.consumer;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class FeignApplication {

    /**
     * Feign日志配置
     * **/
    @Bean
    public Logger.Level feignLogger(){
        return Logger.Level.FULL;
    }


    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class,args);
    }
}
