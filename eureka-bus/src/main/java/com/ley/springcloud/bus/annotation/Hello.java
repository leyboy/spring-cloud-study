package com.ley.springcloud.bus.annotation;

import java.lang.annotation.*;

/**
 * 给一个方法前打印Hello
 * **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Hello {
}
