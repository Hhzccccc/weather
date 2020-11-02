package com.shawnliang.weather.common.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/11/2
 */
@Getter
@AllArgsConstructor
public enum RequestInfoEnum {

    /**
     * 请求头枚举
     */
    APP_SECRET("appSecret", "app密钥"),
    SIGNATURE("signature", "签名"),
    TIMESTAMP("timestamp", "时间戳"),
    RANDOM_STR("randomStr", "随机字符串"),
    ;

    /**
     *
     */
     String name;
     String desc;

}
