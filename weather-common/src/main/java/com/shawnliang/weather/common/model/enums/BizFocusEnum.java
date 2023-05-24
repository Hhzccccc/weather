package com.shawnliang.weather.common.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/10/8
 */
@AllArgsConstructor
@Getter
public enum BizFocusEnum {

    /**
     *
     */
    BAIDU_RETURN_NULL("百度地图查询为空"),
    CONFIG_DB_NULL("查询城市配置为空"),
    ;
    String desc;
}
