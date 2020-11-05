package com.shawnliang.web.controller;

import com.shawnliang.core.vo.ApiResponse;
import com.shawnliang.service.biz.WeatherBizProcess;
import com.shawnliang.weather.common.model.req.ali.AliWeatherBaseReq;
import com.shawnliang.weather.common.model.resp.index.BaseWeatherResp;
import com.shawnliang.weather.common.model.resp.index.Weather15DaysResp;
import com.shawnliang.weather.common.model.resp.index.WeatherLifeResp;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/10/27
 */
@RestController("/weather")
public class WeatherV2Controller {

    @Autowired
    private WeatherBizProcess weatherBizProcess;

    @PostMapping("/base")
    @ApiOperation(value = "基本天气数据展示")
    public ApiResponse<BaseWeatherResp> getBaseWeatherResp(@Validated @RequestBody
            AliWeatherBaseReq aliWeatherBaseReq) {
        return new ApiResponse<>(weatherBizProcess.getBaseWeatherResp(aliWeatherBaseReq));
    }

    @PostMapping("/15-days")
    @ApiOperation(value = "15天天气展示")
    public ApiResponse<Weather15DaysResp> get15DaysWeatherResp(@Validated @RequestBody
            AliWeatherBaseReq aliWeatherBaseReq) {
        return new ApiResponse<>(weatherBizProcess.get15DaysWeatherResp(aliWeatherBaseReq));
    }

    @PostMapping("/life")
    @ApiOperation(value = "生活指数")
    public ApiResponse<WeatherLifeResp> getWeatherLife(@Validated @RequestBody
            AliWeatherBaseReq aliWeatherBaseReq) {
        return new ApiResponse<>(weatherBizProcess.getWeatherLife(aliWeatherBaseReq));
    }

}
