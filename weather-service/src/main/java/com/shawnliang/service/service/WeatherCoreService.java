package com.shawnliang.service.service;

import com.shawnliang.weather.common.model.info.ali.AliWeatherBaseReqInfo;
import com.shawnliang.weather.common.model.resp.index.BaseWeatherResp;
import com.shawnliang.weather.common.model.resp.index.Weather15DaysResp;
import com.shawnliang.weather.common.model.resp.index.WeatherLifeResp;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/10/27
 */
public interface WeatherCoreService {

    /**
     * 首页基本天气数据
     * @param aliWeatherBaseReqInfo
     * @return
     */
    BaseWeatherResp getBaseWeatherResp(AliWeatherBaseReqInfo aliWeatherBaseReqInfo);

    BaseWeatherResp getBaseWeatherRespAsync(AliWeatherBaseReqInfo aliWeatherBaseReqInfo)
            throws Exception;

    /**
     * 15天天气预报
     * @param genWeatherBaseReq
     * @return
     */
    Weather15DaysResp get15DaysWeatherResp(AliWeatherBaseReqInfo genWeatherBaseReq);

    /**
     * 生活指数
     * @param genWeatherBaseReq
     * @return
     */
    WeatherLifeResp getWeatherLife(AliWeatherBaseReqInfo genWeatherBaseReq);
}
