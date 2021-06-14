package org.geektimes.projects.spring.cloud.bus.bridge.redis;

import redis.clients.jedis.Jedis;

public class RedisPublish {
    public static void main(String[] args) {
        System.out.println("发布者 ");
        Jedis jr = null;
        try {
            jr = new Jedis("127.0.0.1", 6379, 3000);// redis服务地址和端口号
            // jr客户端配置监听两个channel
            jr.publish( "customRedisData", "666");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jr != null) {
                jr.disconnect();
            }
        }
    }

}
