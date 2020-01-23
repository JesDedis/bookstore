package com.qfzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/test")
    public String test(){

        //redisTemplate.opsForValue();//操作字符串
        //redisTemplate.opsForList();//操作List
        //redisTemplate.opsForSet();//操作Set
        //redisTemplate.opsForZSet();//操作ZSet
        //redisTemplate.opsForHash();//操作Map
        redisTemplate.opsForValue().set("username","Jackeylove");
        String username = (String) redisTemplate.opsForValue().get("username");
        System.out.println(username);

        stringRedisTemplate.opsForValue().set("password","0000");
        String password = stringRedisTemplate.opsForValue().get("password");
        System.out.println("password");

        return "success";
    }
}