package com.shawnliang.service.biz.impl;

import com.alibaba.fastjson.JSONObject;
import com.shawnliang.service.biz.AliWeatherBizProcess;
import com.shawnliang.service.service.AliWeatherThirdService;
import com.shawnliang.service.service.BizFocusService;
import com.shawnliang.service.service.CityConfigService;
import com.shawnliang.service.util.BaiDuMapUtil;
import com.shawnliang.weather.common.model.enums.BizFocusEnum;
import com.shawnliang.weather.common.model.info.ali.AliWeatherBaseReqInfo;
import com.shawnliang.weather.common.model.info.baidu.BaiDuGeoInfo;
import com.shawnliang.weather.common.model.info.baidu.BaiDuGeoInfo.addressComponent;
import com.shawnliang.weather.common.model.info.biz.LocationInfo;
import com.shawnliang.weather.common.model.req.ali.AliWeatherBaseReq;
import com.shawnliang.weather.common.model.resp.ali.AliMojiAqiForecast5Resp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiAqiResp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiConditionNowResp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiForecast15DaysResp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiForecast24HoursResp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiIndexResp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiLimitResp;
import com.shawnliang.weather.dao.weather_market.entity.CityConfigDo;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/10/4
 */
@Service
@Slf4j
public class AliWeatherBizProcessImpl implements AliWeatherBizProcess {

    @Autowired
    private AliWeatherThirdService aliWeatherThirdService;

    @Autowired
    private CityConfigService cityConfigService;

    @Autowired
    private BizFocusService bizFocusService;

    @Override
    public AliMojiConditionNowResp getConditionNowResp(AliWeatherBaseReq aliWeatherBaseReq) {
        AliWeatherBaseReqInfo aliWeatherBaseReqInfo = genWeatherBaseReq(aliWeatherBaseReq);
        return aliWeatherThirdService.getConditionNowResp(aliWeatherBaseReqInfo);
    }

    @Override
    public AliMojiForecast15DaysResp getForecast15DaysResp(AliWeatherBaseReq aliWeatherBaseReq) {
        AliWeatherBaseReqInfo aliWeatherBaseReqInfo = genWeatherBaseReq(aliWeatherBaseReq);
        return aliWeatherThirdService.getForecast15DaysResp(aliWeatherBaseReqInfo);
    }

    @Override
    public AliMojiForecast24HoursResp getForecast24HoursResp(AliWeatherBaseReq aliWeatherBaseReq) {
        AliWeatherBaseReqInfo aliWeatherBaseReqInfo = genWeatherBaseReq(aliWeatherBaseReq);
        return aliWeatherThirdService.getForecast24HoursResp(aliWeatherBaseReqInfo);
    }

    @Override
    public AliMojiAqiForecast5Resp getAqiForecast5DaysResp(AliWeatherBaseReq aliWeatherBaseReq) {
        AliWeatherBaseReqInfo aliWeatherBaseReqInfo = genWeatherBaseReq(aliWeatherBaseReq);
        return aliWeatherThirdService.getAqiForecast5DaysResp(aliWeatherBaseReqInfo);
    }

    @Override
    public AliMojiLimitResp getLimitResp(AliWeatherBaseReq aliWeatherBaseReq) {
        AliWeatherBaseReqInfo aliWeatherBaseReqInfo = genWeatherBaseReq(aliWeatherBaseReq);
        return aliWeatherThirdService.getLimitResp(aliWeatherBaseReqInfo);
    }

    @Override
    public AliMojiAqiResp getAqiResp(AliWeatherBaseReq aliWeatherBaseReq) {
        AliWeatherBaseReqInfo aliWeatherBaseReqInfo = genWeatherBaseReq(aliWeatherBaseReq);
        return aliWeatherThirdService.getAqiResp(aliWeatherBaseReqInfo);
    }

    @Override
    public AliMojiIndexResp getIndexResp(AliWeatherBaseReq aliWeatherBaseReq) {
        AliWeatherBaseReqInfo aliWeatherBaseReqInfo = genWeatherBaseReq(aliWeatherBaseReq);
        return aliWeatherThirdService.getIndexResp(aliWeatherBaseReqInfo);
    }

    /**
     * 构造返回值
     * @param aliWeatherBaseReq .
     * @return
     */
    @Override
    public AliWeatherBaseReqInfo genWeatherBaseReq(AliWeatherBaseReq aliWeatherBaseReq) {
        AliWeatherBaseReqInfo aliWeatherBaseReqInfo = new AliWeatherBaseReqInfo();

        BaiDuGeoInfo baiDuGeoInfo = BaiDuMapUtil
                .getLocationByGeo(aliWeatherBaseReq.getLat(), aliWeatherBaseReq.getLng());
        if (Objects.isNull(baiDuGeoInfo)) {
            log.info("百度地图API转换异常 {}", aliWeatherBaseReq);
            bizFocusService.buildEntity(BizFocusEnum.BAIDU_RETURN_NULL,
                    JSONObject.toJSONString(aliWeatherBaseReq));
            aliWeatherBaseReqInfo.setCityCode(2);
        } else {
            LocationInfo locationInfo = buildLocationInfoByBaiduInfo(baiDuGeoInfo);
            CityConfigDo configDo = cityConfigService.getByLocationInfo(locationInfo);
            aliWeatherBaseReqInfo.setCityCode(configDo.getCityId());
        }

        return aliWeatherBaseReqInfo;
    }

    /**
     * 构建locationInfo信息
     * @param baiDuGeoInfo
     * @return
     */
    private LocationInfo buildLocationInfoByBaiduInfo(BaiDuGeoInfo baiDuGeoInfo) {
        addressComponent addressComponent = baiDuGeoInfo.getAddressComponent();
        LocationInfo locationInfo = new LocationInfo();
        locationInfo.setProvinceName(addressComponent.getProvince());
        locationInfo.setCityName(addressComponent.getCity());
        locationInfo.setDistrictName(addressComponent.getDistrict());

        return locationInfo;
    }

}
