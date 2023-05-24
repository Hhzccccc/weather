package com.shawnliang.web;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles(profiles = "loc")
@EnableCaching
public class ApplicationTest {


}
