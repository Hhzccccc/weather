package com.shawnliang.service.biz;

import com.shawnliang.weather.common.model.req.ali.AliWeatherBaseReq;
import com.shawnliang.weather.common.model.resp.index.BaseWeatherResp;
import com.shawnliang.weather.common.model.resp.index.Weather15DaysResp;
import com.shawnliang.weather.common.model.resp.index.WeatherLifeResp;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/10/27
 */
public interface WeatherBizProcess {

    BaseWeatherResp getBaseWeatherResp(AliWeatherBaseReq aliWeatherBaseReq);

    Weather15DaysResp get15DaysWeatherResp(AliWeatherBaseReq aliWeatherBaseReq);

    WeatherLifeResp getWeatherLife(AliWeatherBaseReq aliWeatherBaseReq);
}
