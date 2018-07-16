package com.demo.web.simple.handle.api;

import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;

/**
 * Created by yangyang115 on 18-7-14.
 */
public interface UccApiHandle extends Handler<RoutingContext>{

    String getHandleName();

}
