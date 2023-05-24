package com.shawnliang.web.controller;

import com.shawnliang.core.vo.ApiResponse;
import com.shawnliang.service.biz.ConfigBizProcess;
import com.shawnliang.weather.common.model.req.ali.AliWeatherBaseReq;
import com.shawnliang.weather.common.model.resp.config.LocationResp;
import io.swagger.annotations.Api;
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
 * @date : Created in 2020/10/8
 */
@RestController("/config")
@Api(tags = "配置接口")
public class ConfigController {

    @Autowired
    private ConfigBizProcess configBizProcess;

    @PostMapping("/location")
    @ApiOperation("获取配置接口")
    public ApiResponse<LocationResp> location(@Validated @RequestBody AliWeatherBaseReq aliWeatherBaseReq) {
        return new ApiResponse<>(configBizProcess.location(aliWeatherBaseReq));
    }

}
