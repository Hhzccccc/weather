package com.shawnliang.service.biz.impl;

import com.alibaba.fastjson.JSONObject;
import com.shawnliang.service.biz.ConfigBizProcess;
import com.shawnliang.service.service.BizFocusService;
import com.shawnliang.service.util.BaiDuMapUtil;
import com.shawnliang.weather.common.model.enums.BizFocusEnum;
import com.shawnliang.weather.common.model.info.baidu.BaiDuGeoInfo;
import com.shawnliang.weather.common.model.info.baidu.BaiDuGeoInfo.addressComponent;
import com.shawnliang.weather.common.model.req.ali.AliWeatherBaseReq;
import com.shawnliang.weather.common.model.resp.config.LocationResp;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/10/8
 */
@Service
@Slf4j
public class ConfigBizProcessImpl implements ConfigBizProcess {

    @Autowired
    private BizFocusService bizFocusService;

    @Override
    public LocationResp location(AliWeatherBaseReq aliWeatherBaseReq) {
        LocationResp locationResp = new LocationResp();
        locationResp.setDistrictName("朝阳区");

        BaiDuGeoInfo baiDuGeoInfo = BaiDuMapUtil
                .getLocationByGeo(aliWeatherBaseReq.getLat(), aliWeatherBaseReq.getLng());
        if (!Objects.isNull(baiDuGeoInfo) && !Objects.isNull(baiDuGeoInfo.getAddressComponent())) {
            addressComponent addressComponent = baiDuGeoInfo.getAddressComponent();
            if (addressComponent != null) {
                locationResp.setDistrictName(addressComponent.getDistrict());
            }
        } else {
            bizFocusService.buildEntityWithRemark(BizFocusEnum.BAIDU_RETURN_NULL,
                    JSONObject.toJSONString(aliWeatherBaseReq), "首页获取位置为空");
        }
        return locationResp;
    }
}
