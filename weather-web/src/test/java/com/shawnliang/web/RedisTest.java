package com.shawnliang.web;

import com.shawnliang.web.UserTestService.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/26
 */
public class RedisTest extends ApplicationTest{

    @Autowired
    private UserTestService userTestService;

    @Test
    public void findUserTest() {
        for (int i = 0; i < 3; i++) {
            System.out.println("第" + i + "次");
            User user = userTestService.findUser();
            System.out.println(user);
        }
    }

}
