package com.shawnliang.service.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
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
import com.shawnliang.weather.common.model.resp.ali.AliMojiIndexResp.DataBean.LiveIndexBean;
import com.shawnliang.weather.common.model.resp.ali.AliMojiLimitResp;
import java.util.List;
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
    @Cacheable(cacheNames = "weather:forecast15Days", key = "#p0.redisKey + #p0.cityCode")
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
    @Cacheable(cacheNames = "weather:forecast24Hours", key = "#p0.redisKey + #p0.cityCode")
    public AliMojiForecast24HoursResp getForecast24HoursResp(
            AliWeatherBaseReqInfo aliWeatherBaseReqInfo) {
        AliWeatherApiInfo forecast24HoursInfo = aliWeatherApiService.forecast24HoursInfo();
        Map<String, Object> headerMap = buildAliCommonHeader(
                aliWeatherApiService.getAppCode());
        Map<String, Object> bodyMap = buildAliCommonReq(aliWeatherBaseReqInfo.getCityCode(),
                forecast24HoursInfo.getToken());
        AliMojiForecast24HoursResp resp = postResultByAliApi(
                forecast24HoursInfo.getApiUrl(), headerMap,
                bodyMap, AliMojiForecast24HoursResp.class);
        return resp;
    }

    @Override
    @Cacheable(cacheNames = "weather:forecast5Days", key = "#p0.redisKey + #p0.cityCode")
    public AliMojiAqiForecast5Resp getAqiForecast5DaysResp(
            AliWeatherBaseReqInfo aliWeatherBaseReqInfo) {
        AliWeatherApiInfo forecast5DaysInfo = aliWeatherApiService.aqiForecast5DaysInfo();
        Map<String, Object> headerMap = buildAliCommonHeader(
                aliWeatherApiService.getAppCode());
        Map<String, Object> bodyMap = buildAliCommonReq(aliWeatherBaseReqInfo.getCityCode(),
                forecast5DaysInfo.getToken());
        AliMojiAqiForecast5Resp resp = postResultByAliApi(
                forecast5DaysInfo.getApiUrl(), headerMap,
                bodyMap, AliMojiAqiForecast5Resp.class);
        return resp;
    }

    @Override
    @Cacheable(cacheNames = "weather:limit", key = "#p0.redisKey + #p0.cityCode")
    public AliMojiLimitResp getLimitResp(
            AliWeatherBaseReqInfo aliWeatherBaseReqInfo) {
        AliWeatherApiInfo limitInfo = aliWeatherApiService.limitInfo();
        Map<String, Object> headerMap = buildAliCommonHeader(
                aliWeatherApiService.getAppCode());
        Map<String, Object> bodyMap = buildAliCommonReq(aliWeatherBaseReqInfo.getCityCode(),
                limitInfo.getToken());
        AliMojiLimitResp resp = postResultByAliApi(
                limitInfo.getApiUrl(), headerMap,
                bodyMap, AliMojiLimitResp.class);
        return resp;
    }

    @Override
    @Cacheable(cacheNames = "weather:aqiInfo", key = "#p0.redisKey + #p0.cityCode")
    public AliMojiAqiResp getAqiResp(
            AliWeatherBaseReqInfo aliWeatherBaseReqInfo) {
        AliWeatherApiInfo aqiInfo = aliWeatherApiService.aqiInfo();
        Map<String, Object> headerMap = buildAliCommonHeader(
                aliWeatherApiService.getAppCode());
        Map<String, Object> bodyMap = buildAliCommonReq(aliWeatherBaseReqInfo.getCityCode(),
                aqiInfo.getToken());
        AliMojiAqiResp resp = postResultByAliApi(aqiInfo.getApiUrl(), headerMap, bodyMap,
                AliMojiAqiResp.class);
        return resp;
    }

    @Override
    @Cacheable(cacheNames = "weather:indexInfo", key = "#p0.redisKey + #p0.cityCode")
    public AliMojiIndexResp getIndexResp(
            AliWeatherBaseReqInfo aliWeatherBaseReqInfo) {
        AliWeatherApiInfo indexInfo = aliWeatherApiService.indexInfo();
        Map<String, Object> headerMap = buildAliCommonHeader(
                aliWeatherApiService.getAppCode());
        Map<String, Object> bodyMap = buildAliCommonReq(aliWeatherBaseReqInfo.getCityCode(),
                indexInfo.getToken());
        AliMojiIndexResp resp = postResultByAliApi(indexInfo.getApiUrl(), headerMap,
                bodyMap,
                AliMojiIndexResp.class);

        List<LiveIndexBean> results = Lists.newLinkedList();
        Map<String, List<LiveIndexBean>> liveIndex = resp.getData().getLiveIndex();
        liveIndex.forEach((k, v) -> {
            results.addAll(v);
        });
        resp.getData().setResults(results);
        return resp;
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
