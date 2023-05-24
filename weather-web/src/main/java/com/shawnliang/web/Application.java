package com.shawnliang.web;

import com.shawnliang.core.aop.ControllerExceptionHandler;
import com.shawnliang.core.aop.ControllerInterceptor;
import com.shawnliang.core.aop.SignSecurityInterceptor;
import com.shawnliang.weather.common.filter.GlobalFilter;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/8
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@MapperScan("com.shawnliang.weather.dao.weather_market.mapper")
@EnableCaching
@EnableAsync
@Slf4j
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
        log.info("启动完毕---");
    }
}
