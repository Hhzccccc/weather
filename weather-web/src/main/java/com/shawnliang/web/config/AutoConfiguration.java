package com.shawnliang.web.config;

import com.shawnliang.core.aop.ControllerExceptionHandler;
import com.shawnliang.core.aop.ControllerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/9
 */
@Configuration
@Import({
        ControllerExceptionHandler.class
        , ControllerInterceptor.class
})
public class AutoConfiguration {
}
