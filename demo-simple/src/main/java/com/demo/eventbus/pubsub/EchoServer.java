package com.demo.eventbus.pubsub;

import com.hazelcast.config.Config;
import com.hazelcast.config.XmlConfigBuilder;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.spi.cluster.ClusterManager;
import io.vertx.spi.cluster.hazelcast.HazelcastClusterManager;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by yangyang36 on 2018/6/23.
 */
public class EchoServer {
    public static void main(String[] strs){
        //sender
        NotifySenderVerticle senderVerticle = new NotifySenderVerticle();
        Config cfg = null;
        try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("outside_cluster.xml");
             InputStream bis = new BufferedInputStream(is)) {
            cfg = new XmlConfigBuilder(bis).build();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        ClusterManager clusterManager = new HazelcastClusterManager(cfg);
        Vertx.clusteredVertx(new VertxOptions().setClustered(true).setClusterManager(clusterManager), res -> {
            if (res.succeeded()) {
                Vertx vertx = res.result();
                vertx.deployVerticle(senderVerticle);
            } else {
                res.cause().printStackTrace();
            }
        });

        //echo
        EchoVerticle echoVerticle = new EchoVerticle();
        echoVerticle.setNotifySender(senderVerticle);
        Vertx.clusteredVertx(new VertxOptions().setClustered(true), res -> {
            if (res.succeeded()) {
                Vertx vertx = res.result();
                vertx.deployVerticle(echoVerticle);
            } else {
                res.cause().printStackTrace();
            }
        });
    }
}
