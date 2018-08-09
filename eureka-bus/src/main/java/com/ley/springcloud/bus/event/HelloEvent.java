package com.ley.springcloud.bus.event;

import org.springframework.context.ApplicationEvent;

public class HelloEvent extends ApplicationEvent {


    private String hello;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public HelloEvent(Object source,String hello) {
        super(source);
        this.hello=hello;
    }


    public String getHello() {
        return hello;
    }
}
