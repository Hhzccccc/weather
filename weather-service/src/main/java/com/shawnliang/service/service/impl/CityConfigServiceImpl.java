package com.shawnliang.service.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.shawnliang.service.service.BizFocusService;
import com.shawnliang.service.service.CityConfigService;
import com.shawnliang.weather.common.model.enums.BizFocusEnum;
import com.shawnliang.weather.common.model.info.biz.LocationInfo;
import com.shawnliang.weather.dao.weather_market.entity.CityConfigDo;
import com.shawnliang.weather.dao.weather_market.repository.CityConfigDoRepository;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/10/4
 */
@Service
@Slf4j
public class CityConfigServiceImpl implements CityConfigService {

    @Autowired
    private CityConfigDoRepository cityConfigDoRepository;

    @Autowired
    private BizFocusService bizFocusService;

    @Override
    @Cacheable(cacheNames = "city:getByLocationInfo", key = "#p0.provinceName + #p0.cityName + #p0.districtName")
    public CityConfigDo getByLocationInfo(
            LocationInfo locationInfo) {
        String provinceName = locationInfo.getProvinceName();
        String cityName = locationInfo.getCityName();
        String districtName = locationInfo.getDistrictName();

        CityConfigDo configDo;
        configDo = cityConfigDoRepository
                .getByProvinceAndCityLikeDistrict(provinceName, cityName, districtName);
        if (Objects.isNull(configDo)) {
            log.info("查询省市区为空：{}", locationInfo);
            configDo = cityConfigDoRepository.getByCityName(cityName);
        }
        if (Objects.isNull(configDo)) {
            log.info("查询市为空：{}", locationInfo);
            configDo = cityConfigDoRepository.getByProvinceName(provinceName);
        }
        if (Objects.isNull(configDo)) {
            log.info("查询省为空：{}", locationInfo);
            configDo = buildDefaultResult();
            bizFocusService.buildEntity(BizFocusEnum.CONFIG_DB_NULL,
                    JSONObject.toJSONString(locationInfo));
        }
        return configDo;
    }

    /**
     * 构建默认的返回值
     * @return
     */
    private CityConfigDo buildDefaultResult() {
        CityConfigDo cityConfigDo = new CityConfigDo();
        cityConfigDo.setCityId(2);
        cityConfigDo.setProvinceName("北京市");
        cityConfigDo.setCityName("北京市");
        cityConfigDo.setDistrictName("北京市");

        return cityConfigDo;
    }
}
