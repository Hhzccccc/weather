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

}
