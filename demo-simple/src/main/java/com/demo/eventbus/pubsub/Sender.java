package com.demo.eventbus.pubsub;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.eventbus.EventBus;

import java.util.function.Consumer;

/**
 * Created by yangyang36 on 2018/6/19.
 */
public class Sender  extends AbstractVerticle {

    public static void main(String[] srcs){
        Consumer<Vertx> runner = vertx -> {
            try {
                vertx.deployVerticle(new Sender());
            } catch (Throwable t) {
                t.printStackTrace();
            }
        };

        Vertx.clusteredVertx(new VertxOptions().setClustered(true), res -> {
            if (res.succeeded()) {
                Vertx vertx = res.result();
                runner.accept(vertx);
            } else {
                res.cause().printStackTrace();
            }
        });
    }

    @Override
    public void start() throws Exception {
        EventBus eventBus = vertx.eventBus();


        vertx.setPeriodic(1000, v -> eventBus.publish("my-event", "Some news!"));
    }
}
