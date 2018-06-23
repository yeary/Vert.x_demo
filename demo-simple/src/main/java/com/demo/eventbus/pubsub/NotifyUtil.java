package com.demo.eventbus.pubsub;

/**
 * Created by yangyang36 on 2018/6/23.
 */
public class NotifyUtil {

    private final static NotifySender NOTIFY_SENDER;

    static {
        NOTIFY_SENDER = new NotifySender();
    }

    public static void publish(String msg){
        NOTIFY_SENDER.publish(msg);
    }
}
