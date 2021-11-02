package com.kula.controller.redisTest;

import com.kula.entity.UserEntity;
import com.kula.mapper.UserMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author kula
 * @create 2021/10/20 下午4:49
 */
@RestController
public class UserController {

    @Resource
    private UserMapper userMapper;

    /**
     * cacheNames:类似一个文件夹，管理key
     * key:需要加上单引号
     *
     *
     * @param id
     * @return
     */
    @GetMapping("/")
    @Cacheable(cacheNames = "User", key = "'id'")
    public UserEntity getUserById(@RequestParam("id") Integer id) {
        return userMapper.getUserById(id);
    }


    public static void main(String[] args) {
        int a = 14646;
        int b = 18900;
        double n = 3.5;
        double sum = n*b;
        System.out.println(sum);
        System.out.println(sum-69599);
    }
}
