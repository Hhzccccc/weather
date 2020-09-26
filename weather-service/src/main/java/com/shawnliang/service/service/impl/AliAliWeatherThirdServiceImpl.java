package com.shawnliang.service.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.shawnliang.core.utils.BeanUtil;
import com.shawnliang.core.utils.HttpUtil;
import com.shawnliang.service.service.AliWeatherApiService;
import com.shawnliang.service.service.AliWeatherThirdService;
import com.shawnliang.weather.common.exception.BizErrorEnum;
import com.shawnliang.weather.common.exception.BusinessException;
import com.shawnliang.weather.common.model.info.ali.AliWeatherApiInfo;
import com.shawnliang.weather.common.model.info.ali.AliWeatherBaseReqInfo;
import com.shawnliang.weather.common.model.resp.ali.AliMojiAqiForecast5Resp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiAqiResp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiConditionNowResp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiForecast15DaysResp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiForecast24HoursResp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiIndexResp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiLimitResp;
import java.util.Map;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/18
 */
@Service
@Slf4j
public class AliAliWeatherThirdServiceImpl implements AliWeatherThirdService {

    @Autowired
    private AliWeatherApiService aliWeatherApiService;

    @Override
    @Cacheable(cacheNames = "weather:nowCondition", key = "#p0.redisKey + #p0.cityCode")
    public AliMojiConditionNowResp getConditionNowResp(AliWeatherBaseReqInfo aliWeatherBaseReqInfo) {
        AliWeatherApiInfo conditionInfo = aliWeatherApiService.conditionNowInfo();
        Map<String, Object> headerMap = buildAliCommonHeader(
                aliWeatherApiService.getAppCode());
        Map<String, Object> bodyMap = buildAliCommonReq(aliWeatherBaseReqInfo.getCityCode(),
                conditionInfo.getToken());
        AliMojiConditionNowResp resp = postResultByAliApi(conditionInfo.getApiUrl(), headerMap,
                bodyMap, AliMojiConditionNowResp.class);
        return resp;
    }

    @Override
    public AliMojiForecast15DaysResp getForecast15DaysResp(AliWeatherBaseReqInfo aliWeatherBaseReqInfo) {
        AliWeatherApiInfo forecast15DaysInfo = aliWeatherApiService.forecast15DaysInfo();
        Map<String, Object> headerMap = buildAliCommonHeader(
                aliWeatherApiService.getAppCode());
        Map<String, Object> bodyMap = buildAliCommonReq(aliWeatherBaseReqInfo.getCityCode(),
                forecast15DaysInfo.getToken());
        AliMojiForecast15DaysResp resp = postResultByAliApi(forecast15DaysInfo.getApiUrl(), headerMap,
                bodyMap, AliMojiForecast15DaysResp.class);
        return resp;
    }

    @Override
    public AliMojiForecast24HoursResp getForecast24HoursResp() {

        return null;
    }

    @Override
    public AliMojiAqiForecast5Resp getAqiForecast5DaysResp() {
        return null;
    }

    @Override
    public AliMojiLimitResp getLimitResp() {
        return null;
    }

    @Override
    public AliMojiAqiResp getAqiResp() {
        return null;
    }

    @Override
    public AliMojiIndexResp getIndexResp() {
        return null;
    }

    /**
     * 请求阿里墨迹，获取返回结果
     * @param url
     * @param header
     * @param body
     * @return
     */
     static <T> T postResultByAliApi(String url, Map<String, Object> header, Map<String, Object> body,
            Class<T> clazz) {
        JSONObject jsonResult = HttpUtil.postRequest(url, header, body);
        if (Objects.isNull(jsonResult)) {
            throw new BusinessException(BizErrorEnum.ALI_WEATHER_ERROR);
        }
        return BeanUtil.copyPropertiesJson(jsonResult, clazz);
    }
}
