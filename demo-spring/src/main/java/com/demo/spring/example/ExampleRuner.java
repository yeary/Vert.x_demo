package com.demo.spring.example;

import com.demo.spring.example.article.WebEchoArticle;
import com.demo.spring.example.context.ExampleSpringConfiguration;
import io.vertx.core.Vertx;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.security.provider.certpath.Vertex;

/**
 * Created by yangyang115 on 18-7-4.
 */
public class ExampleRuner {

    public static void main(String[] srcs){
        ApplicationContext context = new AnnotationConfigApplicationContext(ExampleSpringConfiguration.class);
    }
}
