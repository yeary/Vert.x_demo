package com.demo.web.simple.handle.api.namespace;

import com.demo.web.simple.handle.api.UccApiHandle;
import io.vertx.ext.web.RoutingContext;

/**
 * Created by yangyang115 on 18-7-14.
 */
public class NamespaceAddHandle implements UccApiHandle {

    @Override
    public String getHandleName() {
        return "namespaceAddHandle";
    }

    @Override
    public void handle(RoutingContext routingContext) {
        routingContext.response().setStatusCode(200).end("add success !!");
    }
}
