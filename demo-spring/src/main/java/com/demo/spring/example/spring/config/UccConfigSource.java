package com.demo.spring.example.spring.config;

import java.lang.annotation.*;

/**
 * Created by yangyang115 on 18-7-5.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface UccConfigSource {

    String value() default "def";
}
