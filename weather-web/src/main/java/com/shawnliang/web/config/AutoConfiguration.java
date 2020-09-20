package com.shawnliang.web.config;

import com.shawnliang.core.aop.ControllerExceptionHandler;
import com.shawnliang.core.aop.ControllerInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Description :  这里面的类统一交给spring来管理 .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/9
 */
@Configuration
@Import({
        ControllerExceptionHandler.class
        , ControllerInterceptor.class
})
@ComponentScan({"com.shawnliang.weather.dao", "com.shawnliang.service"})
public class AutoConfiguration {
}
