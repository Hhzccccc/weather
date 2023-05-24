package com.shawnliang.core.component;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/10/30
 */
@Component
@Getter
public class PropertiesComponent {

    @Value("${biz.app.secret:b5yi7t8unguw609p}")
    private String appSecret;

    /**
     * 24 小时空气质量随机数
     */
    @Value("${biz.random.24-hours-num:15}")
    private Integer random24HoursNum;

}
