package com.ley.springcloud.feign;

import com.ley.springcloud.listener.RandomServerPortApplicationEnvironmentPreparedEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class FeignProviderApplication {

    public static void main(String[] args) {
        SpringApplication application=new SpringApplication(FeignProviderApplication.class);
        application.addListeners(new RandomServerPortApplicationEnvironmentPreparedEventListener());
        application.run(args);
    }
}


