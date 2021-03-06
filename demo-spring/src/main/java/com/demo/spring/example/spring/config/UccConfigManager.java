package com.demo.spring.example.spring.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Created by yangyang115 on 18-7-5.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(UccConfigRegister.class)
public @interface UccConfigManager {
}
