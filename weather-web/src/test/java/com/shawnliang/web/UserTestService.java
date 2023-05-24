package com.shawnliang.web;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/26
 */
@Service
public class UserTestService {


    @Cacheable(cacheNames = "aa")
    public User findUser() {
        System.out.println("执行方法...");
        return new User( 18);
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class User implements Serializable {
        Integer id;
    }
}
