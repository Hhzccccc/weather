package com.shawnliang.web.controller;

import com.shawnliang.core.vo.ApiResponse;
import com.shawnliang.service.biz.AliWeatherBizProcess;
import com.shawnliang.weather.common.model.req.ali.AliWeatherBaseReq;
import com.shawnliang.weather.common.model.resp.ali.AliMojiAqiForecast5Resp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiAqiResp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiConditionNowResp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiForecast15DaysResp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiForecast24HoursResp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiIndexResp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiLimitResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/10/4
 */
//@RestController("/weather2")
// @Api(tags = "天气接口")
public class WeatherController {

    @Autowired
    private AliWeatherBizProcess aliWeatherBizProcess;

    //// @PostMapping("/now")
   // // @ApiOperation(value = "获取 实况天气")
    public ApiResponse<AliMojiConditionNowResp> getConditionNowResp(@Validated @RequestBody
            AliWeatherBaseReq aliWeatherBaseReq) {
        return new ApiResponse<>(aliWeatherBizProcess.getConditionNowResp(aliWeatherBaseReq));
    }

    // @PostMapping("/15days")
    //// @ApiOperation(value = "获取 15天天气")
    public ApiResponse<AliMojiForecast15DaysResp> getForecast15DaysResp(@Validated @RequestBody
            AliWeatherBaseReq aliWeatherBaseReq) {
        return new ApiResponse<>(aliWeatherBizProcess.getForecast15DaysResp(aliWeatherBaseReq));
    }

    // @PostMapping("/24hours")
    // @ApiOperation(value = "获取 24小时天气")
    public ApiResponse<AliMojiForecast24HoursResp> getForecast24HoursResp(@Validated @RequestBody
            AliWeatherBaseReq aliWeatherBaseReq) {
        return new ApiResponse<>(aliWeatherBizProcess.getForecast24HoursResp(aliWeatherBaseReq));
    }

    // @PostMapping("/5days-aqi")
    // @ApiOperation(value = "5天AQI数据")
    public ApiResponse<AliMojiAqiForecast5Resp> getAqiForecast5DaysResp(@Validated @RequestBody
            AliWeatherBaseReq aliWeatherBaseReq) {
        return new ApiResponse<>(aliWeatherBizProcess.getAqiForecast5DaysResp(aliWeatherBaseReq));
    }

    // @PostMapping("/limit")
    // @ApiOperation(value = "获取 各地限行数据")
    public ApiResponse<AliMojiLimitResp> getLimitResp(@Validated @RequestBody
            AliWeatherBaseReq aliWeatherBaseReq) {
        return new ApiResponse<>(aliWeatherBizProcess.getLimitResp(aliWeatherBaseReq));
    }
    // @PostMapping("/air-aqi")
    // @ApiOperation(value = "获取 空气质量")
    public ApiResponse<AliMojiAqiResp> getAqiResp(@Validated @RequestBody
            AliWeatherBaseReq aliWeatherBaseReq) {
        return new ApiResponse<>(aliWeatherBizProcess.getAqiResp(aliWeatherBaseReq));
    }

    // @PostMapping("/index")
    // @ApiOperation(value = "获取 各项生活指数据")
    public ApiResponse<AliMojiIndexResp> getIndexResp(@Validated @RequestBody
            AliWeatherBaseReq aliWeatherBaseReq) {
        return new ApiResponse<>(aliWeatherBizProcess.getIndexResp(aliWeatherBaseReq));
    }

}
