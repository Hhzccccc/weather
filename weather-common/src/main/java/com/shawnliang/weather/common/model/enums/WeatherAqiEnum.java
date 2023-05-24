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
    LIGHT("轻度"),
    MID("中度"),
    HEAVY("重度"),
    SERIOUS("严重"),
    BURST("爆表"),
    OTHER("其他"),
    ;


    private String desc;

}
