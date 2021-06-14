package org.geektimes.projects.spring.cloud.bus.bridge.subscribe;

import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MessageListenerAdapters {
    private Map<String, MessageListenerAdapter> adapterMap = new HashMap<>();

    private final RedisSerializer<?> redisSerializer;

    public MessageListenerAdapters(List<MessageHandler<?>> handlers, RedisSerializer<?> redisSerializer){
        this.redisSerializer = redisSerializer;
        if (!CollectionUtils.isEmpty(handlers)) {
            adapterMap = handlers
                    .stream()
                    .collect(Collectors.toMap(MessageHandler::getTopic, this::toMessageListenerAdapter));
        }
    }

    public MessageListenerAdapter toMessageListenerAdapter(MessageHandler<?> handler) {
        MessageListenerAdapter adapter = new MessageListenerAdapter(handler, "onMessage");
        adapter.setSerializer(redisSerializer);
        adapter.afterPropertiesSet();
        return adapter;
    }

    public Map<String, MessageListenerAdapter> getAdapterMap() {
        return adapterMap;
    }
}
