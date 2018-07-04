package com.demo.spring.example.handle;

import io.vertx.ext.web.RoutingContext;
import jdk.internal.org.objectweb.asm.Handle;

/**
 * Created by yangyang115 on 18-7-4.
 */
public class NameSpaceHandler{

    public void handleGetNamespace(RoutingContext routingContext) {
        String id = routingContext.request().getParam("id");
        routingContext.response().putHeader("content-type", "application/json").end("{\"id\":\""+id+"\"}");
    }
}
