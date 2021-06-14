package org.geektimes.projects.spring.cloud.bus.bridge.subscribe;

public interface MessageHandler<T> {

    void onMessage(T t, String pattern);
    String getTopic();

}
