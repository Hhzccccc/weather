package com.shawnliang.service.service;

import com.shawnliang.weather.common.model.info.ali.AliWeatherApiInfo;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/20
 */
public interface AliWeatherApiService {

    /**
     * 获取appCode
     * @return
     */
    String getAppCode();

    /**
     * 获取限行数据相关接口
     * @return
     */
    AliWeatherApiInfo limitInfo();

    /**
     * 获取空气质量指数相关接口
     * @return
     */
    AliWeatherApiInfo aqiInfo();

    /**
     * 获取生活指数相关接口
     * @return
     */
    AliWeatherApiInfo indexInfo();

    /**
     * 获取天气预警相关接口
     * @return
     */
    AliWeatherApiInfo alertInfo();

    /**
     * 获取天气预报24小时相关接口
     * @return
     */
    AliWeatherApiInfo forecast24HoursInfo();

    /**
     * 获取天气预报15天相关接口
     * @return
     */
    AliWeatherApiInfo forecast15DaysInfo();

    /**
     * 获取天气实况相关接口
     * @return
     */
    AliWeatherApiInfo conditionNowInfo();

    /**
     * 获取AQI预报5天相关接口
     * @return
     */
    AliWeatherApiInfo aqiForecast5DaysInfo();
}
