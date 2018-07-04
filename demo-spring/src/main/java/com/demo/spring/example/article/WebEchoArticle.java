package com.demo.spring.example.article;

import com.demo.spring.example.handle.NameSpaceHandler;
import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by yangyang115 on 18-7-4.
 */
@Component(value = "webEchoArticle")
public class WebEchoArticle extends AbstractVerticle {

    @Autowired
    private NameSpaceHandler nameSpaceHandler;

    @Override
    public void start() throws Exception {
        Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());
        router.get("/namespace/:id").handler(nameSpaceHandler::handleGetNamespace);
        vertx.createHttpServer().requestHandler(router::accept).listen(8080);
    }
}
