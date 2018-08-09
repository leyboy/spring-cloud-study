package com.ley.springcloud.bus.aspect;

import com.ley.springcloud.bus.annotation.Hello;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Hello
    public void hello() {
        };
}
