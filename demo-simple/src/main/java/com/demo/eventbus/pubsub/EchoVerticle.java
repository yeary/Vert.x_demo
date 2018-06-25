package com.demo.eventbus.pubsub;

import io.vertx.core.AbstractVerticle;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yangyang36 on 2018/6/20.
 */
public class EchoVerticle extends AbstractVerticle {

    private NotifySenderVerticle notifySender;

    public EchoVerticle(){
    }

    @Override
    public void start() throws Exception {
        AtomicInteger counter = new AtomicInteger();
        vertx.createHttpServer().requestHandler(req -> {
            String msg = "send news "+counter.incrementAndGet()+" times";
            vertx.eventBus().publish("my-event", msg);
            notifySender.publish(msg+" for outside");
            req.response()
                    .putHeader("content-type", "text/plain")
                    .end("Hello from Vert.x!");
        }).listen(8080);
    }

    public void setNotifySender(NotifySenderVerticle notifySender) {
        this.notifySender = notifySender;
    }

}
