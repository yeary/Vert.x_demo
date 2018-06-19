package com.demo.simple;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

public class EchoServer  {

    public static void main(String[] srcs) {
        Vertx.vertx().createHttpServer().requestHandler(req -> {
            req.response()
                    .putHeader("content-type", "text/plain")
                    .end("Hello from Vert.x!");
        }).listen(8080);
    }
}