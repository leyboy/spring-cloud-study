package com.ley.springcloud.bus.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class HelloAspect {

    @Pointcut("@annotation(com.ley.springcloud.bus.annotation.Hello)")
    protected void pointcut(){

    }

    @Before(value = "pointcut()")
    public void printHello(JoinPoint joinPoint){
        Object target=joinPoint.getTarget();
        log.info("hello ,class: {},method: {}",target.getClass(),joinPoint.getSignature());
    }
}
