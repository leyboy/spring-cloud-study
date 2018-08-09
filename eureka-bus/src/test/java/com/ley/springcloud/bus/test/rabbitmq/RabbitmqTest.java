package com.ley.springcloud.bus.test.rabbitmq;

import com.ley.springcloud.bus.SpringCloudBusApplication;
import com.ley.springcloud.bus.rabbitmq.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringCloudBusApplication.class})
public class RabbitmqTest {

    @Autowired
    private Sender sender;

    @Test
    public void hello(){
        sender.send();
    }
}

