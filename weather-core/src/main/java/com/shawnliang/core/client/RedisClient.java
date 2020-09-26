package com.shawnliang.core.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/26
 */
@Component
public class RedisClient {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

}
