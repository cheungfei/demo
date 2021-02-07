package com.example.demo.day.day07;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2021-02-06 8:12
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
//@Retention(RetentionPolicy.SOURCE)
@Documented
@Inherited
public @interface Component {
    String identifier() default "";
}
