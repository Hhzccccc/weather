package com.shawnliang.service.biz;

import com.shawnliang.weather.common.model.req.ali.AliWeatherBaseReq;
import com.shawnliang.weather.common.model.resp.config.LocationResp;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/10/8
 */
public interface ConfigBizProcess {

    /**
     * 经纬度获取当前的地理位置
     * @param aliWeatherBaseReq
     * @return
     */
    LocationResp location(AliWeatherBaseReq aliWeatherBaseReq);
}
