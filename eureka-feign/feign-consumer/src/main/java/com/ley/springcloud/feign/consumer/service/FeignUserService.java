package com.ley.springcloud.feign.consumer.service;

import com.ley.springcloud.service.UserService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "feign-provider")
public interface FeignUserService extends UserService {
}
