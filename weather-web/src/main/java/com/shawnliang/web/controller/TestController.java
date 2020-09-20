package com.shawnliang.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shawnliang.core.vo.ApiResponse;
import com.shawnliang.service.service.AliWeatherThirdService;
import com.shawnliang.weather.common.model.info.ali.AliWeatherBaseReqInfo;
import com.shawnliang.weather.common.model.req.AUpdateReq;
import com.shawnliang.weather.common.model.resp.ali.AliMojiConditionNowResp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiForecast15DaysResp;
import com.shawnliang.weather.dao.convertor.AConvertor;
import com.shawnliang.weather.dao.info.AInfo;
import com.shawnliang.weather.dao.weather_market.entity.A;
import com.shawnliang.weather.dao.weather_market.repository.ARepository;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/8
 */
@RestController("/test")
@Slf4j
public class TestController {

    @Autowired
    private ARepository aRepository;

    @Autowired
    private AConvertor aConvertor;

    @Autowired
    private AliWeatherThirdService aliWeatherThirdService;

    @ApiOperation("now测试")
    @GetMapping("/now")
    public ApiResponse<AliMojiConditionNowResp> testNowResp() {
        AliMojiConditionNowResp conditionNowResp = aliWeatherThirdService
                .getConditionNowResp(AliWeatherBaseReqInfo.builder().cityCode(49).build());
        return new ApiResponse<>(conditionNowResp);
    }

    @ApiOperation("15天测试")
    @GetMapping("/15days")
    public ApiResponse<AliMojiForecast15DaysResp> test15DaysResp() {
        AliMojiForecast15DaysResp aliMojiForecast15DaysResp = aliWeatherThirdService
                .getForecast15DaysResp(AliWeatherBaseReqInfo.builder().cityCode(49).build());
        return new ApiResponse<>(aliMojiForecast15DaysResp);
    }

    @ApiOperation("测试首页接口")
    @GetMapping("/index")
    public ApiResponse<String> test() {
        int i = 1 /0;
        return new ApiResponse<>("test");
    }

    @ApiOperation("增删改查（分页）")
    @GetMapping("/page")
    public ApiResponse<IPage<A>> pageAll() {
        IPage<A> aiPage = aRepository.pageA();
        return new ApiResponse<>(aiPage);
    }

    @GetMapping("/save")
    @ApiOperation("保存")
    public ApiResponse saveA() {
        A a = new A();
        a.setAge(20);
        a.setUserName("陈够");
        aRepository.save(a);

        return new ApiResponse();
    }

    @PostMapping("/update")
    @ApiOperation("更新A")
    public ApiResponse updateA(@Validated @RequestBody AUpdateReq aUpdateReq) {
        A a = new A();
        a.setId(aUpdateReq.getId());
        a.setUserName(aUpdateReq.getUserName());

        aRepository.updateById(a);
        return new ApiResponse();
    }

    @PostMapping("/convert")
    @ApiOperation("转换A")
    public ApiResponse convertTest(@Validated @RequestBody AUpdateReq aUpdateReq) {
        AInfo aInfo = aConvertor.reqToInfo(aUpdateReq);
        log.info("aInfo {}", aInfo);

        A a = aConvertor.infoToDo(aInfo);
        log.info("aDo {}", a);

        return new ApiResponse();
    }

}
