package com.ley.springcloud.provider.controller;

import com.ley.springcloud.provider.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class UserController {

    private static List<User> users= new ArrayList<>();

    @Autowired
    private DiscoveryClient discoveryClient;

    static {
        users.add(new User(1,"刘恩源1"));
        users.add(new User(2,"刘恩源2"));
        users.add(new User(3,"刘恩源3"));
        users.add(new User(4,"刘恩源4"));
    }


    @GetMapping(value = "/users/{id}")
    public User getUserById(@PathVariable Integer id){
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        log.info("host" + serviceInstance.getHost() + ",service_id: " +
                serviceInstance.getServiceId());
        return users.get(id);
    }


    @PostMapping(value = "/users")
    public Boolean addUser(@RequestParam(value = "id")Integer id,@RequestParam(value = "name")String name){
        User user = new User(id,name);
        users.add(user);
        return true;
    }
}
