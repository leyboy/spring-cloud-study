package com.ley.springcloud.feign.controller;

import com.ley.springcloud.bean.User;
import com.ley.springcloud.service.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserService {

    @Override
    public User getUserById(Integer id) {
        return new User(1,"刘恩源");
    }

    @Override
    public String insertUser(User user) {
        return null;
    }
}
