package com.ley.springcloud.consumer.controller;

import com.ley.springcloud.consumer.bean.User;
import com.ley.springcloud.consumer.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 异步调用
     **/
    @GetMapping(value = "/users/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    /**
     * 异步调用
     **/
    @GetMapping(value = "/users1/{id}")
    public User getUserByIdAsync(@PathVariable Integer id) {
        try {
            return userService.getUserByIdAsync(id).get(2, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.info(e.getMessage());
            return null;
        }
    }

    /**
     * 响应式编程RxJava
     **/
    @GetMapping(value = "/users2/{id}")
    public User getUserByIdReactive(@PathVariable Integer id) {
        List<User> userList = new ArrayList<>(1);
        //进行订阅
        userService.getUserByIdReactive(id).subscribe(user->{
            userList.add(user);
        });
        return userList.get(0);
    }
}
