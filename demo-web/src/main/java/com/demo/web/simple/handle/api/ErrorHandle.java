package com.demo.web.simple.handle.api;

import io.vertx.ext.web.RoutingContext;

/**
 * Created by yangyang115 on 18-7-14.
 */
public class ErrorHandle implements UccApiHandle{

    @Override
    public String getHandleName() {
        return "errorHandle";
    }

    @Override
    public void handle(RoutingContext routingContext) {

    }
}
