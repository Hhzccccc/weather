package com.shawnliang.service.biz.impl;

import com.alibaba.fastjson.JSONObject;
import com.shawnliang.core.utils.LunarUtil;
import com.shawnliang.core.utils.TimeUtil;
import com.shawnliang.service.biz.ConfigBizProcess;
import com.shawnliang.service.service.BizFocusService;
import com.shawnliang.service.util.BaiDuMapUtil;
import com.shawnliang.weather.common.model.enums.BizFocusEnum;
import com.shawnliang.weather.common.model.info.baidu.BaiDuGeoInfo;
import com.shawnliang.weather.common.model.info.baidu.BaiDuGeoInfo.addressComponent;
import com.shawnliang.weather.common.model.req.ali.AliWeatherBaseReq;
import com.shawnliang.weather.common.model.resp.config.LocationResp;
import com.shawnliang.weather.common.model.resp.config.LocationResp.DateInfoResp;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
        locationResp.setDateInfoResp(buildDateInfo());
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

    private DateInfoResp buildDateInfo() {
        LocalDate now = LocalDate.now();
        String monthDesc = TimeUtil.getMonthChinese(now.getMonthValue());
        String dateDesc = StringUtils.join(monthDesc, "月", now.getDayOfMonth(), "日");
        String dayWeekDesc = TimeUtil.getDayWeekDesc(now);
        String chineseDateDesc = new LunarUtil(Calendar.getInstance()).toString();

        return DateInfoResp.builder()
                .dateDesc(dateDesc)
                .weekDesc(dayWeekDesc)
                .chineseDateDesc(chineseDateDesc)
                .build();
    }
}
