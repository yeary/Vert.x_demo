package com.demo.web.simple.handle.api;

import io.vertx.ext.web.RoutingContext;

/**
 * Created by yangyang115 on 18-7-14.
 */
public class ValidateHandle implements UccApiHandle{

    @Override
    public String getHandleName() {
        return "validateHandle";
    }

    @Override
    public void handle(RoutingContext routingContext) {
        System.out.println("validate successed");
        routingContext.next();
    }
}
