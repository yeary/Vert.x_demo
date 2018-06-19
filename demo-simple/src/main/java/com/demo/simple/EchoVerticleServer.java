package com.demo.simple;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

/**
 * Created by yangyang36 on 2018/6/19.
 */
public class EchoVerticleServer extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        vertx.createHttpServer().requestHandler(req -> {
            req.response()
                    .putHeader("content-type", "text/plain")
                    .end("Hello from Vert.x!");
        }).listen(8080);
    }

    public static void main(String[] strs){
        EchoVerticleServer echoVerticleServer = new EchoVerticleServer();
        Vertx.vertx().deployVerticle(echoVerticleServer);
    }
}
