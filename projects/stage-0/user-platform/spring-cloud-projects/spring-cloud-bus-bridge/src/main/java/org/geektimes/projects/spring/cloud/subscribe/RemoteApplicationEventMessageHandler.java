package org.geektimes.projects.spring.cloud.subscribe;

import org.geektimes.projects.spring.cloud.message.RedisMessage;
import org.springframework.cloud.bus.BusProperties;
import org.springframework.cloud.bus.ServiceMatcher;
import org.springframework.cloud.bus.event.RemoteApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;

public class RemoteApplicationEventMessageHandler  implements MessageHandler<RedisMessage>{
    private final ApplicationEventPublisher publisher;

    private final BusProperties properties;

    private final ServiceMatcher matcher;

    public RemoteApplicationEventMessageHandler(ApplicationEventPublisher publisher, BusProperties properties,
                                                ServiceMatcher matcher) {
        this.publisher = publisher;
        this.properties = properties;
        this.matcher = matcher;
    }

    @Override
    public void onMessage(RedisMessage message, String pattern) {
        Object playLoad = message.getPlayLoad();
        RemoteApplicationEvent event = (RemoteApplicationEvent) playLoad;
        //过滤掉自己发送自己订阅的事件
        if (!matcher.isFromSelf(event)) {
            System.out.printf("topic=%s remoteEvent=%s\n", pattern, event);
            publisher.publishEvent(event);
        }
    }

    @Override
    public String getTopic() {
        return properties.getDestination();
    }
}
