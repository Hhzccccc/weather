package com.shawnliang.service.biz.impl;

import com.alibaba.fastjson.JSONObject;
import com.shawnliang.service.biz.WeatherBizProcess;
import com.shawnliang.service.constant.ConstantUtils;
import com.shawnliang.service.service.BizFocusService;
import com.shawnliang.service.service.CityConfigService;
import com.shawnliang.service.service.WeatherCoreService;
import com.shawnliang.service.util.BaiDuMapUtil;
import com.shawnliang.weather.common.exception.BusinessException;
import com.shawnliang.weather.common.exception.CommonError;
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

    private void commonValidate(AliWeatherBaseReq aliWeatherBaseReq) {
        String lat = aliWeatherBaseReq.getLat();
        String lng = aliWeatherBaseReq.getLng();

        try {
            Double latDouble = Double.parseDouble(lat);
            Double lngDouble = Double.parseDouble(lng);

            if (latDouble.equals(0.0)|| lngDouble.equals(0.0)) {
                throw new BusinessException(CommonError.NOT_OPEN_LOCATION);
            }
        } catch (Exception e) {

        }

        if (Objects.equals(ConstantUtils.ZERO_PARAMS, lat) || Objects.equals(lng, ConstantUtils.ZERO_PARAMS)) {
            throw new BusinessException(CommonError.NOT_OPEN_LOCATION);
        }
    }

    @Override
    public BaseWeatherResp getBaseWeatherResp(AliWeatherBaseReq aliWeatherBaseReq) {
        commonValidate(aliWeatherBaseReq);

        try {
            return weatherCoreService.getBaseWeatherRespAsync(genWeatherBaseReq(aliWeatherBaseReq));
        } catch (Exception e) {
           log.error("获取基本天气异常", e);
           throw new BusinessException(CommonError.COMMON_BIZ_ERROR, "网络开小差了");
        }
    }

    @Override
    public Weather15DaysResp get15DaysWeatherResp(AliWeatherBaseReq aliWeatherBaseReq) {
        commonValidate(aliWeatherBaseReq);
        return weatherCoreService.get15DaysWeatherResp(genWeatherBaseReq(aliWeatherBaseReq));
    }

    @Override
    public WeatherLifeResp getWeatherLife(AliWeatherBaseReq aliWeatherBaseReq) {
        commonValidate(aliWeatherBaseReq);
        return weatherCoreService.getWeatherLife(genWeatherBaseReq(aliWeatherBaseReq));
    }

    private AliWeatherBaseReqInfo genWeatherBaseReq(AliWeatherBaseReq aliWeatherBaseReq) {
        commonValidate(aliWeatherBaseReq);

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
