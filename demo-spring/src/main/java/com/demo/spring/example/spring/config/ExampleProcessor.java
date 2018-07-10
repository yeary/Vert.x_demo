package com.demo.spring.example.spring.config;

import com.demo.spring.example.config.ConfigSource;
import com.demo.spring.example.context.ExampleSpringConfiguration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by yangyang115 on 18-7-5.
 */
public class ExampleProcessor extends AbstractProcessor {

    @Override
    protected void processField(Object bean, String beanName, Field field) {
        UccConfigSource annotation = AnnotationUtils.getAnnotation(field, UccConfigSource.class);
        if (annotation != null) {
            String value = annotation.value();
            ConfigSource configSource = new ConfigSource();
            configSource.setValue(value);

            ReflectionUtils.makeAccessible(field);
            ReflectionUtils.setField(field, bean, configSource);
        }


    }

    @Override
    protected void processMethod(Object bean, String beanName, Method method) {

    }
}
