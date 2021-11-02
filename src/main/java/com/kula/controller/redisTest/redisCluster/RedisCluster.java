package com.kula.controller.redisTest.redisCluster;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author kula
 * @create 2021/11/2 下午2:26
 *
 * Jedis支持集群工具，使查询支持重定向查询
 *
 */
public class RedisCluster {
    private static JedisCluster jedis;

    static {
        // 添加集群的服务节点Set集合
        Set<HostAndPort> hostAndPortsSet = new HashSet<HostAndPort>();
        // 添加节点
        hostAndPortsSet.add(new HostAndPort("192.168.212.163", 7000));
        hostAndPortsSet.add(new HostAndPort("192.168.212.163", 7001));
        hostAndPortsSet.add(new HostAndPort("192.168.212.163", 7002));
        hostAndPortsSet.add(new HostAndPort("192.168.212.163", 7003));
        hostAndPortsSet.add(new HostAndPort("192.168.212.163", 7004));
        hostAndPortsSet.add(new HostAndPort("192.168.212.163", 7005));
        // Jedis连接池配置
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 最大空闲连接数, 默认8个
        jedisPoolConfig.setMaxIdle(100);
        // 最大连接数, 默认8个
        jedisPoolConfig.setMaxTotal(500);
        //最小空闲连接数, 默认0
        jedisPoolConfig.setMinIdle(0);
        // 获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1 设置2秒
        jedisPoolConfig.setMaxWaitMillis(2000);
        //对拿到的connection进行validateObject校验
        jedisPoolConfig.setTestOnBorrow(true);
        jedis = new JedisCluster(hostAndPortsSet, jedisPoolConfig);
    }

    public String getKye(String key) {
        return jedis.get(key);
    }

    public static void main(String[] args) {
        String value = new RedisCluster().getKye("fff");
        System.out.println("value:" + value);
    }
}
