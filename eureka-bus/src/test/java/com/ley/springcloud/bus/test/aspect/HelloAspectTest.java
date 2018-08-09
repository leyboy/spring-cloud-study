package com.ley.springcloud.bus.test.aspect;

import com.ley.springcloud.bus.aspect.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ComponentScan(value = "com.ley.springcloud.bus.aspect")
public class HelloAspectTest {

    @Autowired
    private HelloService helloService;

    @Test
    public void testHelloAspect(){
        helloService.hello();
    }
}
