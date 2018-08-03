package com.ley.springcloud.provider;

import com.ley.springcloud.provider.utils.RandomServerPort;
import org.junit.Test;

public class OnceRandomTest {

    @Test
    public void testOnceRandom(){
        RandomServerPort serverPort = new RandomServerPort();
        System.out.println(serverPort.nextValue(1000,2000));
        System.out.println(serverPort.nextValue(1000,2000));
    }
}
