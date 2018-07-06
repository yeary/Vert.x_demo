package com.demo.spring.example;

import com.alibaba.fastjson.JSON;
import com.demo.spring.example.article.WebEchoArticle;
import com.demo.spring.example.config.ConfigSource;
import com.demo.spring.example.context.ExampleSpringConfiguration;
import com.demo.spring.example.context.InitUccAnnotationBean;
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
        InitUccAnnotationBean initUccAnnotationBean = (InitUccAnnotationBean)context.getBean("initUccAnnotationBean");
        System.out.println(JSON.toJSON(initUccAnnotationBean.getXxAdfConfigSource()));
    }
}
