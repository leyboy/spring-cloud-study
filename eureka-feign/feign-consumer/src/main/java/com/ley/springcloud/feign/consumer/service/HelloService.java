package com.ley.springcloud.feign.consumer.service;

import com.ley.springcloud.feign.consumer.configuration.DisableHystrixConfiguration;
import com.ley.springcloud.feign.consumer.configuration.FeignFullLogConfiguration;
import com.ley.springcloud.feign.consumer.service.fallback.HelloServiceFallback;
import com.ley.springcloud.feign.consumer.utils.ServiceInstanceConstants;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Feign:声明式服务调用,不区分服务大小写
 **/
@FeignClient(value = ServiceInstanceConstants.SERVICE_INSTANCE_EUREKA_PROVIDER,
        configuration = {//DisableHystrixConfiguration.class,
                FeignFullLogConfiguration.class},
        fallback = HelloServiceFallback.class)
public interface HelloService {

    @GetMapping(value = "/hello")
    String sayHello();
}
