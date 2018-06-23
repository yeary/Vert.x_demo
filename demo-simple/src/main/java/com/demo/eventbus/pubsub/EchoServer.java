package com.demo.eventbus.pubsub;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yangyang36 on 2018/6/20.
 */
public class EchoServer extends AbstractVerticle {

    private NotifySender notifySender;

    public EchoServer(){
        Vertx.clusteredVertx(new VertxOptions().setClustered(true), res -> {
            if (res.succeeded()) {
                Vertx vertx = res.result();
                vertx.deployVerticle(this);
            } else {
                res.cause().printStackTrace();
            }
        });
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

    public void setNotifySender(NotifySender notifySender) {
        this.notifySender = notifySender;
    }

    public static void main(String[] strs){
        EchoServer echoServer = new EchoServer();
        echoServer.setNotifySender(new NotifySender());
    }
}
