package com.kula.controller.redisTest.redisCluster;

import redis.clients.jedis.Jedis;

/**
 * @Author kula
 * @create 2021/11/2 下午2:16
 * Jedis不支持集群，不支持重定向查询
 */
public class JedisTest {
    public static void main(String[] args) {
        /**
         * docker中的redis
         */
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String value = jedis.get("name");
        System.out.println(value);

    }
}
