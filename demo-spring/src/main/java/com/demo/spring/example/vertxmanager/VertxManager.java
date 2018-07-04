package com.demo.spring.example.vertxmanager;

import com.demo.spring.example.article.WebEchoArticle;
import io.vertx.core.Vertx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by yangyang115 on 18-7-4.
 */
@Component
public class VertxManager {

    @Autowired
    WebEchoArticle webEchoArticle;

    @PostConstruct
    public void init(){
        Vertx.vertx().deployVerticle(webEchoArticle);
    }
}
