package com.shawnliang.web.controller;

import com.shawnliang.core.vo.ApiResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/8
 */
@RestController("/test")
public class TestController {

    @ApiOperation("测试首页接口")
    @GetMapping("/index")
    public ApiResponse<String> test() {
        int i = 1 /0;
        return new ApiResponse<>("test");
    }

}
