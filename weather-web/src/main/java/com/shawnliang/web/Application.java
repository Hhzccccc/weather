package com.shawnliang.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/8
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@MapperScan("com.shawnliang.weather.dao.weather_market.mapper")
@EnableCaching
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
