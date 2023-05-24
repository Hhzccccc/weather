package com.shawnliang.service.service;

import com.shawnliang.weather.common.model.info.biz.LocationInfo;
import com.shawnliang.weather.dao.weather_market.entity.CityConfigDo;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/10/4
 */
public interface CityConfigService {

    /**
     * 根据位置对象查询城市配置表
     *
     * @param locationInfo@return
     */
    CityConfigDo getByLocationInfo(
            LocationInfo locationInfo);

}
