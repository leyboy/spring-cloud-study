package com.ley.springcloud.feign.consumer.controller;

import com.ley.springcloud.bean.User;
import com.ley.springcloud.feign.consumer.service.FeignUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignUserController {

    @Autowired
    private FeignUserService feignUserService;

    @GetMapping(value = "/feign/user/{id}")
    public User getUserById(@PathVariable Integer id){
        return feignUserService.getUserById(id);
    }
}
