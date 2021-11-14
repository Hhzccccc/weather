package com.shawnliang.web.repo;

import com.shawnliang.weather.dao.weather_market.entity.UserLogDo;
import com.shawnliang.weather.dao.weather_market.repository.UserLogDoRepository;
import com.shawnliang.web.Application;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/11/14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles(profiles = "loc")
public class UserLogRepositoryTest {

    @Autowired
    private UserLogDoRepository userLogDoRepository;

    @Test
    public void testInsert() {
        UserLogDo userLogDo = new UserLogDo();

        userLogDo.setImei("abcd-imei");
        userLogDo.setRequestUrl("http://www.baidu.com");
        userLogDo.setUserId(123);
        userLogDo.setVisitDate(LocalDate.now());
        userLogDo.setVisitTime(LocalDateTime.now());
        userLogDo.setIp("127.0.0.1");
        userLogDo.setUseTime(2000L);

        userLogDoRepository.save(userLogDo);
        System.out.println("测试成功！");
    }

}
