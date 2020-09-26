package com.shawnliang.web.config;

import static org.springframework.data.redis.cache.RedisCacheConfiguration.defaultCacheConfig;

import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleCacheErrorHandler;
import org.springframework.cache.interceptor.SimpleCacheResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/26
 */
@Configuration
@Slf4j
public class RedisCacheConfig extends CachingConfigurerSupport {

    @Autowired
    private RedisConnectionFactory factory;

    /**
     * 自定义生成redis-key
     *
     * @return
     */
    @Override
    @Bean
    public KeyGenerator keyGenerator() {
        return (o, method, objects) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(o.getClass().getName()).append(":");
            sb.append(method.getName()).append(":");
            for (Object obj : objects) {
                sb.append(obj.toString());
            }
            log.info("keyGenerator=" + sb.toString());
            return sb.toString();
        };
    }

    @Bean
    public RedisTemplate<Object, Object> redisTemplate() {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);

        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();

        redisTemplate.setKeySerializer(genericJackson2JsonRedisSerializer);
        redisTemplate.setValueSerializer(genericJackson2JsonRedisSerializer);

        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(genericJackson2JsonRedisSerializer);
        return redisTemplate;
    }


    @Bean
    @Override
    public CacheResolver cacheResolver() {
        return new SimpleCacheResolver(cacheManager());
    }

    @Bean
    @Override
    public CacheErrorHandler errorHandler() {
        // 用于捕获从Cache中进行CRUD时的异常的回调处理器。
        return new SimpleCacheErrorHandler();
    }

    /**
     * 配置缓存的机制
     * @return
     */
    @Bean
    @Override
    public CacheManager cacheManager() {
        RedisCacheConfiguration cacheConfiguration =
                defaultCacheConfig()
                        .disableCachingNullValues()
                        .entryTtl(Duration.ofMinutes(15))
                        .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
        return RedisCacheManager.builder(factory).cacheDefaults(cacheConfiguration).build();

    }

}
