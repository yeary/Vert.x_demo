package com.demo.eventbus.pubsub;

import com.hazelcast.config.Config;
import com.hazelcast.config.XmlConfigBuilder;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.spi.cluster.ClusterManager;
import io.vertx.spi.cluster.hazelcast.HazelcastClusterManager;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by yangyang36 on 2018/6/19.
 */
public class NotifySenderVerticle extends AbstractVerticle {

    public NotifySenderVerticle() {

    }

    public void publish(String str){
        EventBus eventBus = vertx.eventBus();
        eventBus.publish("out-event", str);
    }

    @Override
    public void start() throws Exception {
        super.start();
    }
}
