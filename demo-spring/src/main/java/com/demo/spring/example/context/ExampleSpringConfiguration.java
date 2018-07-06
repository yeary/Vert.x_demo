package com.demo.spring.example.context;

import com.demo.spring.example.spring.config.UccConfigManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yangyang115 on 18-7-4.
 */
@Configuration
@ComponentScan("com.demo.spring.example")
@UccConfigManager
public class ExampleSpringConfiguration {

    @Bean
    public InitUccAnnotationBean initUccAnnotationBean(){
        return new InitUccAnnotationBean();
    }

}
