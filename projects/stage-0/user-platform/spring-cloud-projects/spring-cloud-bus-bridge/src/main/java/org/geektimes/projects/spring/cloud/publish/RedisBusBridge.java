package org.geektimes.projects.spring.cloud.publish;

import org.geektimes.projects.spring.cloud.message.RedisMessage;
import org.springframework.cloud.bus.BusBridge;
import org.springframework.cloud.bus.BusProperties;
import org.springframework.cloud.bus.event.RemoteApplicationEvent;
import org.springframework.data.redis.core.RedisTemplate;
//import pers.cocoadel.learning.spring.cloud.bus.redis.message.RedisMessage;

public class RedisBusBridge implements BusBridge {

    private  BusProperties properties;

    private  RedisTemplate<String,Object> redisTemplate;

    public RedisBusBridge(BusProperties properties, RedisTemplate<String, Object> redisTemplate) {
        this.properties = properties;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void send(RemoteApplicationEvent event) {
        RedisMessage redisMessage = new RedisMessage();
        redisMessage.setClazz(event.getClass().getName());
        redisMessage.setPlayLoad(event);
        redisTemplate.convertAndSend(properties.getDestination(),redisMessage);
    }
}
