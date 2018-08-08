package com.ley.springcloud.service;

import com.ley.springcloud.bean.User;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api")
public interface UserService {

    @GetMapping(value = "/user/{id}")
    User getUserById(@PathVariable(value = "id") Integer id);


    @PostMapping(value = "/user")
    String insertUser(@RequestBody User user);
}
