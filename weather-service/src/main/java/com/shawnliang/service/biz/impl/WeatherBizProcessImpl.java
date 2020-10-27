package com.shawnliang.service.biz.impl;

import com.alibaba.fastjson.JSONObject;
import com.shawnliang.service.biz.WeatherBizProcess;
import com.shawnliang.service.service.BizFocusService;
import com.shawnliang.service.service.CityConfigService;
import com.shawnliang.service.service.WeatherCoreService;
import com.shawnliang.service.util.BaiDuMapUtil;
import com.shawnliang.weather.common.model.enums.BizFocusEnum;
import com.shawnliang.weather.common.model.info.ali.AliWeatherBaseReqInfo;
import com.shawnliang.weather.common.model.info.baidu.BaiDuGeoInfo;
import com.shawnliang.weather.common.model.info.baidu.BaiDuGeoInfo.addressComponent;
import com.shawnliang.weather.common.model.info.biz.LocationInfo;
import com.shawnliang.weather.common.model.req.ali.AliWeatherBaseReq;
import com.shawnliang.weather.common.model.resp.index.BaseWeatherResp;
import com.shawnliang.weather.common.model.resp.index.Weather15DaysResp;
import com.shawnliang.weather.common.model.resp.index.WeatherLifeResp;
import com.shawnliang.weather.dao.weather_market.entity.CityConfigDo;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/10/27
 */
@Service
@Slf4j
public class WeatherBizProcessImpl implements WeatherBizProcess {

    @Autowired
    private WeatherCoreService weatherCoreService;

    @Autowired
    private BizFocusService bizFocusService;

    @Autowired
    private CityConfigService cityConfigService;

    @Override
    public BaseWeatherResp getBaseWeatherResp(AliWeatherBaseReq aliWeatherBaseReq) {
        return weatherCoreService.getBaseWeatherResp(genWeatherBaseReq(aliWeatherBaseReq));
    }

    @Override
    public Weather15DaysResp get15DaysWeatherResp(AliWeatherBaseReq aliWeatherBaseReq) {
        return weatherCoreService.get15DaysWeatherResp(genWeatherBaseReq(aliWeatherBaseReq));
    }

    @Override
    public WeatherLifeResp getWeatherLife(AliWeatherBaseReq aliWeatherBaseReq) {
        return weatherCoreService.getWeatherLife(genWeatherBaseReq(aliWeatherBaseReq));
    }

    private AliWeatherBaseReqInfo genWeatherBaseReq(AliWeatherBaseReq aliWeatherBaseReq) {
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
