package com.demo.web.simple;

import com.demo.web.simple.comment.utils.RouteMappingPropertyUtil;
import com.demo.web.simple.handle.api.UccApiHandle;
import com.demo.web.simple.route.RouteMapping;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

import java.util.*;


/**
 * Created by yangyang36 on 2018/6/27.
 */
public class WebEchoArticle extends AbstractVerticle {

    private static Map<String, UccApiHandle> apiHandleMap = new HashMap<>();

    private static Set<RouteMapping> routeMappings = new HashSet<>();

    static {
        ServiceLoader<UccApiHandle> serviceLoader = ServiceLoader.load(UccApiHandle.class);
        for (UccApiHandle apiHandle : serviceLoader) {
            System.out.println(apiHandle.getClass().getName());
            apiHandleMap.put(apiHandle.getHandleName(), apiHandle);
        }
        routeMappings.addAll(RouteMappingPropertyUtil.getRouteMappings());
    }


    @Override
    public void start() throws Exception {
        Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());
        for(RouteMapping routeMapping : routeMappings){
            Route route = null;
            switch (routeMapping.getMethod()){
                case GET:
                    route = router.get(routeMapping.getPath());
                    break;
                case POST:
                    route = router.post(routeMapping.getPath());
                    break;
                case PUT:
                    route = router.put(routeMapping.getPath());
                    break;
                case DELETE:
                    route = router.delete(routeMapping.getPath());
                    break;
                case PATCH:
                    route = router.patch(routeMapping.getPath());
                    break;
            }
            route.failureHandler(apiHandleMap.get("errorHandle"));
            for(String handleName : routeMapping.getHandles()){
                route.handler(apiHandleMap.get(handleName));
            }

        }
        vertx.createHttpServer().requestHandler(router::accept).listen(8080);
    }

    public static void main(String[] args) {
        Vertx.vertx().deployVerticle(new WebEchoArticle());
    }

}
