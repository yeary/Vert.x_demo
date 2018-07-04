package com.demo.web.simple;

import com.alibaba.fastjson.JSON;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;


/**
 * Created by yangyang36 on 2018/6/27.
 */
public class WebEchoArticle extends AbstractVerticle{

    @Override
    public void start() throws Exception {
        Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());
        router.get("/namespace/:id").failureHandler(this::HandleError).handler(this::handleValiteGetNamespace).handler(this::handleGetNamespace);
        router.get("/namespace/:namespaceId/config/:id").handler(this::handleGetNamespaceConfig);
        vertx.createHttpServer().requestHandler(router::accept).listen(8080);
    }

    private void handleValiteGetNamespace(RoutingContext routingContext) {
        String id = routingContext.request().getParam("id");
        if (id == null || "0".equals(id)) {
            routingContext.fail(new RuntimeException("id:"+id+" is not right!"));
        }else {
            routingContext.next();
        }
    }

    private void handleGetNamespace(RoutingContext routingContext) {
        String id = routingContext.request().getParam("id");
        routingContext.response().putHeader("content-type", "application/json").end("{\"id\":\""+id+"\"}");
    }

    private void handleGetNamespaceConfig(RoutingContext routingContext){
        String id = routingContext.request().getParam("id");
        String namespaceId = routingContext.request().getParam("namespaceId");
        HttpServerResponse response = routingContext.response();
        if (id == null) {
            sendError(400, response);
        } else {
            response.putHeader("content-type", "application/json").end("{\"id\":\""+id+"\",\"namespaceId\":\""+namespaceId+"\"}");
        }
    }

    private void HandleError(RoutingContext routingContext){
        Throwable throwable = routingContext.failure();
        routingContext.response().setStatusCode(400).end(throwable.getMessage());
    }

    private void sendError(int statusCode, HttpServerResponse response) {
        response.setStatusCode(statusCode).end();
    }

    public static void main(String args[]){
        Vertx.vertx().deployVerticle(new WebEchoArticle());
    }
}
