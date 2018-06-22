package com.demo.eventbus.pubsub;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yangyang36 on 2018/6/20.
 */
public class EchoServer extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        AtomicInteger counter = new AtomicInteger();
        vertx.createHttpServer().requestHandler(req -> {
            vertx.eventBus().publish("my-event","send news "+counter.incrementAndGet()+" times");
            req.response()
                    .putHeader("content-type", "text/plain")
                    .end("Hello from Vert.x!");
        }).listen(8080);
    }

    public static void main(String[] strs){
        Vertx.clusteredVertx(new VertxOptions().setClustered(true), res -> {
            if (res.succeeded()) {
                Vertx vertx = res.result();
                vertx.deployVerticle(new EchoServer());
            } else {
                res.cause().printStackTrace();
            }
        });
    }
}
