package com.shawnliang.service.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.shawnliang.core.utils.BeanUtil;
import com.shawnliang.core.utils.HttpUtil;
import com.shawnliang.service.constant.ConstantUtils;
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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * 查询阿里的市况天气信息
     * @return
     */
    public JSONObject getCondition() {
        Map<String, Object> headers = new HashMap<>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put(ConstantUtils.AUTHORIZATION, "APPCODE " + "7593492cf9cd4dc5a1dbf3b656cdbdc2");
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, Object> bodys = new HashMap<>();
        bodys.put("cityId", "49");
        bodys.put("token", "008d2ad9197090c5dddc76f583616606");

        JSONObject jsonObject = HttpUtil
                .postRequest(StringUtils.join(ConstantUtils.ALI_WEATHER_HOST, ConstantUtils.ALI_WEATHER_24_HOURS)
                , headers, bodys);
        return jsonObject;
    }

    public JSONObject forecast15days() {
        Map<String, Object> headers = new HashMap<>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put(ConstantUtils.AUTHORIZATION, "APPCODE " + "7593492cf9cd4dc5a1dbf3b656cdbdc2");
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, Object> bodys = new HashMap<>();
        bodys.put("cityId", "49");
        bodys.put("token", "f9f212e1996e79e0e602b08ea297ffb0");

        JSONObject jsonObject = HttpUtil.postRequest(StringUtils.join(ConstantUtils.ALI_WEATHER_HOST, "/whapi/json/alicityweather/forecast15days")
                , headers, bodys);
        return jsonObject;
    }


    @Autowired
    private AliWeatherApiService aliWeatherApiService;

    @Override
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
