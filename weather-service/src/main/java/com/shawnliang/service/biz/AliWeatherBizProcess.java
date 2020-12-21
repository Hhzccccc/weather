package com.shawnliang.service.biz;

import com.shawnliang.weather.common.model.info.ali.AliWeatherBaseReqInfo;
import com.shawnliang.weather.common.model.req.ali.AliWeatherBaseReq;
import com.shawnliang.weather.common.model.resp.ali.AliMojiAqiForecast5Resp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiAqiResp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiConditionNowResp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiForecast15DaysResp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiForecast24HoursResp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiIndexResp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiLimitResp;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/10/4
 */
public interface AliWeatherBizProcess {

    /**
     * 获取当前天气
     *
     * @param aliWeatherBaseReq
     * @return
     */
    AliMojiConditionNowResp getConditionNowResp(
            AliWeatherBaseReq aliWeatherBaseReq);

    /**
     * 获取 15天天气
     *
     * @param aliWeatherBaseReq .
     * @return
     */
    AliMojiForecast15DaysResp getForecast15DaysResp(
            AliWeatherBaseReq aliWeatherBaseReq);

    /**
     * 获取24小时天气
     *
     * @param aliWeatherBaseReq .
     * @return .
     */
    AliMojiForecast24HoursResp getForecast24HoursResp(
            AliWeatherBaseReq aliWeatherBaseReq);

    /**
     * 提供未来5天AQI数据
     *
     * @param aliWeatherBaseReq
     * @return .
     */
    AliMojiAqiForecast5Resp getAqiForecast5DaysResp(
            AliWeatherBaseReq aliWeatherBaseReq);

    /**
     * 提供各地限行数据
     *
     * @param aliWeatherBaseReq
     * @return .
     */
    AliMojiLimitResp getLimitResp(
            AliWeatherBaseReq aliWeatherBaseReq);

    /**
     * 获取空气质量数据
     *
     * @param aliWeatherBaseReq
     * @return
     */
    AliMojiAqiResp getAqiResp(
            AliWeatherBaseReq aliWeatherBaseReq);

    /**
     * 获取各项生活指数数据
     *
     * @param aliWeatherBaseReq
     * @return
     */
    AliMojiIndexResp getIndexResp(
            AliWeatherBaseReq aliWeatherBaseReq);

    /**
     * 构造返回值
     * @param aliWeatherBaseReq
     * @return
     */
    AliWeatherBaseReqInfo genWeatherBaseReq(
            AliWeatherBaseReq aliWeatherBaseReq);
}
