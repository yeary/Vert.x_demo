package com.demo.spring.example.spring.config;

import com.demo.spring.example.config.ConfigSource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import java.util.LinkedHashMap;
import java.util.Map;

public class PropertySourcesProcessor implements BeanFactoryPostProcessor, EnvironmentAware, PriorityOrdered {

    private static final Map<String, ConfigSource> CONFIG_SOUECE_MAP = new LinkedHashMap<>();

    private ConfigurableEnvironment environment;

    public static void addConfigSource(ConfigSource configSource){
        CONFIG_SOUECE_MAP.put(configSource.getValue(), configSource);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = (ConfigurableEnvironment) environment;
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}