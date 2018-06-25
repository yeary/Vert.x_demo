package com.demo.eventbus.pubsub;

import com.hazelcast.config.Config;
import com.hazelcast.config.XmlConfigBuilder;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.spi.cluster.ClusterManager;
import io.vertx.spi.cluster.hazelcast.HazelcastClusterManager;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.function.Consumer;

/**
 * Created by yangyang36 on 2018/6/19.
 */
public class NotifyReciver extends AbstractVerticle{

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        EventBus eventBus = vertx.eventBus();
        eventBus.consumer("out-event", msg->{
            System.out.println("Received news on consumer, msg is [ "+ msg.body()+" ]");
        });

    }

    public static void main(String[] srcs){
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
                vertx.deployVerticle(new NotifyReciver());
            } else {
                res.cause().printStackTrace();
            }
        });
    }
}
