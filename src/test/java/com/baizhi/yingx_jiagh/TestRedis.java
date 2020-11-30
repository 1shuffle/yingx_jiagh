package com.baizhi.yingx_jiagh;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
public class TestRedis {
    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void testredis(){
        redisTemplate.opsForValue().set("age","18");



    }
}
