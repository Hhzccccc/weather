package com.shawnliang.weather.common.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/10/27
 */
@Getter
@AllArgsConstructor
public enum WeatherAqiEnum {

    /**
     * 天气指数枚举
     */
    EXCELLENT("优"),
    GOOD("良"),
    LIGHT("轻度污染"),
    MID("中度污染"),
    HEAVY("重度污染"),
    SERIOUS("严重污染"),
    BURST("爆表"),
    OTHER("其他"),
    ;


    private String desc;

}
