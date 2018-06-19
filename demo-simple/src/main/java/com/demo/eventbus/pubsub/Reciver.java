package com.demo.eventbus.pubsub;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.eventbus.EventBus;

import java.util.function.Consumer;

/**
 * Created by yangyang36 on 2018/6/19.
 */
public class Reciver extends AbstractVerticle{

    public static void main(String[] srcs){

        Consumer<Vertx> runner = vertx -> {
            try {
                vertx.deployVerticle(new Reciver());
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
    public void start(Future<Void> startFuture) throws Exception {
        EventBus eventBus = vertx.eventBus();
        eventBus.consumer("my-event", msg->{
            System.out.println("Received news on consumer, msg is [ "+ msg+" ]");
        });

    }
}
