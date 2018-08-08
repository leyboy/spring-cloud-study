package com.ley.springcloud.feign.consumer.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignFullLogConfiguration {

    @Bean(value = "feignFullLogger")
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
