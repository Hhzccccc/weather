package com.shawnliang.service.service.impl;

import com.shawnliang.service.service.AliWeatherApiService;
import com.shawnliang.weather.common.model.info.ali.AliWeatherApiInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/20
 */
@Service
public class AliWeatherApiServiceImpl implements AliWeatherApiService {

    /** 阿里墨迹天气 url**/
    @Value("${biz.weather-service.ali.weather.base-url:https://finacityid.market.alicloudapi.com}")
    private String aliBaseUrl;

    /** 阿里墨迹 实时天气 token**/
    @Value("${biz.weather-service.ali.weather.condition-token:50b53ff8dd7d9fa320d3d3ca32cf8ed1}")
    private String conditionToken;

    /** 阿里墨迹 15 天预报天气 token**/
    @Value("${biz.weather-service.ali.weather.forecast15Hours-token:f9f212e1996e79e0e602b08ea297ffb0}")
    private String forecast15DaysToken;

    /** 阿里墨迹天气 24小时预报天气token**/
    @Value("${biz.weather-service.ali.weather.forecast24days-token:008d2ad9197090c5dddc76f583616606}")
    private String forecast24hoursToken;

    /** 阿里墨迹天气 未来5天AQI token**/
    @Value("${biz.weather-service.ali.weather.aqiForecast5days-token:0418c1f4e5e66405d33556418189d2d0}")
    private String aqiForecast5daysToken;

    /** 阿里墨迹天气 token**/
    @Value("${biz.weather-service.ali.weather.limit-token:27200005b3475f8b0e26428f9bfb13e9}")
    private String limitToken;

    /** 阿里墨迹天气 token**/
    @Value("${biz.weather-service.ali.weather.aqi-token:8b36edf8e3444047812be3a59d27bab9}")
    private String aqiToken;

    /** 阿里墨迹天气 token**/
    @Value("${biz.weather-service.ali.weather.index-token:5944a84ec4a071359cc4f6928b797f91}")
    private String indexToken;

    /** 阿里墨迹天气 token**/
    @Value("${biz.weather-service.ali.weather.app-code:7593492cf9cd4dc5a1dbf3b656cdbdc2}")
    private String appCode;

    @Override
    public String getAppCode() {
        return this.appCode;
    }

    @Override
    public AliWeatherApiInfo limitInfo() {
        return AliWeatherApiInfo.builder()
                .apiUrl(getCompleteUrl("/whapi/json/alicityweather/limit"))
                .token(this.limitToken)
                .build();
    }

    @Override
    public AliWeatherApiInfo aqiInfo() {
        return AliWeatherApiInfo.builder()
                .apiUrl(getCompleteUrl("/whapi/json/alicityweather/aqi"))
                .token(this.aqiToken)
                .build()
                ;
    }

    @Override
    public AliWeatherApiInfo indexInfo() {
        return AliWeatherApiInfo.builder()
                .apiUrl(getCompleteUrl("/whapi/json/alicityweather/index"))
                .token(this.indexToken)
                .build();
    }

    @Override
    public AliWeatherApiInfo alertInfo() {
        return AliWeatherApiInfo.builder()
                .apiUrl(getCompleteUrl("/whapi/json/alicityweather/index"))
                .token(this.indexToken)
                .build();
    }

    @Override
    public AliWeatherApiInfo forecast24HoursInfo() {
        return AliWeatherApiInfo.builder()
                .apiUrl(getCompleteUrl("/whapi/json/alicityweather/forecast24hours"))
                .token(this.forecast24hoursToken)
                .build();
    }

    @Override
    public AliWeatherApiInfo forecast15DaysInfo() {
        return AliWeatherApiInfo.builder()
                .apiUrl(getCompleteUrl("/whapi/json/alicityweather/forecast15days"))
                .token(this.forecast15DaysToken)
                .build();
    }

    @Override
    public AliWeatherApiInfo conditionNowInfo() {
        return AliWeatherApiInfo.builder()
                .apiUrl(getCompleteUrl("/whapi/json/alicityweather/condition"))
                .token(this.conditionToken)
                .build();
    }

    @Override
    public AliWeatherApiInfo aqiForecast5DaysInfo() {
        return AliWeatherApiInfo.builder()
                .apiUrl(getCompleteUrl("/whapi/json/alicityweather/aqiforecast5days"))
                .token(this.aqiForecast5daysToken)
                .build();
    }

    /**
     * 获取 完整的请求路径
     * @param path .
     * @return
     */
    private String getCompleteUrl(String path) {
        return StringUtils.join(aliBaseUrl, path);
    }
}
