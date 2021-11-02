package com.kula.controller.redisTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author kula
 * @create 2021/10/14 下午3:26
 */
@RestController
@RequestMapping("/")
public class Controller_01 {
    /**
     * 多级缓存可以采用装饰模式重构
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
}
