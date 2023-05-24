package com.shawnliang.service.service;

import com.shawnliang.service.constant.ConstantUtils;
import com.shawnliang.weather.common.model.info.ali.AliWeatherBaseReqInfo;
import com.shawnliang.weather.common.model.resp.ali.AliMojiAqiForecast5Resp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiAqiResp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiConditionNowResp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiForecast15DaysResp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiForecast24HoursResp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiIndexResp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiLimitResp;
import java.util.HashMap;
import java.util.Map;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/18
 */
public interface AliWeatherThirdService extends WeatherThirdService {

    /**
     * 获取 实况天气
     * @param aliWeatherBaseReqInfo .
     * @return
     */
    AliMojiConditionNowResp getConditionNowResp(AliWeatherBaseReqInfo aliWeatherBaseReqInfo);

    /**
     * 获取 15天天气
     * @param aliWeatherBaseReqInfo .
     * @return
     */
    AliMojiForecast15DaysResp getForecast15DaysResp(AliWeatherBaseReqInfo aliWeatherBaseReqInfo);

    /**
     * 获取24小时天气
     * @return .
     * @param aliWeatherBaseReqInfo .
     */
    AliMojiForecast24HoursResp getForecast24HoursResp(
            AliWeatherBaseReqInfo aliWeatherBaseReqInfo);

    /**
     *提供未来5天AQI数据
     * @return .
     * @param aliWeatherBaseReqInfo
     */
    AliMojiAqiForecast5Resp getAqiForecast5DaysResp(
            AliWeatherBaseReqInfo aliWeatherBaseReqInfo);

    /**
     * 提供各地限行数据
     * @return .
     * @param aliWeatherBaseReqInfo
     */
    AliMojiLimitResp getLimitResp(
            AliWeatherBaseReqInfo aliWeatherBaseReqInfo);

    /**
     * 获取空气质量数据
     * @return
     * @param aliWeatherBaseReqInfo
     */
    AliMojiAqiResp getAqiResp(
            AliWeatherBaseReqInfo aliWeatherBaseReqInfo);

    /**
     * 获取各项生活指数数据
     * @return
     * @param aliWeatherBaseReqInfo
     */
    AliMojiIndexResp getIndexResp(
            AliWeatherBaseReqInfo aliWeatherBaseReqInfo);

    /**
     * 生成公共头请求参数
     * @param appCode .
     * @return .
     */
    default Map<String, Object> buildAliCommonHeader(String appCode) {
        Map<String, Object> headerMap = new HashMap<>(2);
        headerMap.put(ConstantUtils.AUTHORIZATION, "APPCODE " + appCode);
        headerMap.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        return headerMap;
    }

    /**
     * 生成公共请求参数
     * @param cityId  请求的城市ID
     * @param token 对应api的token
     * @return
     */
    default Map<String, Object> buildAliCommonReq(Integer cityId, String token) {
        Map<String, Object> bodyMap = new HashMap<>(2);
        bodyMap.put("cityId", cityId);
        bodyMap.put("token", token);
        return bodyMap;
    }

}
