package com.shawnliang.web.controller;

import com.shawnliang.core.vo.ApiResponse;
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

    @GetMapping("/index")
    public ApiResponse<String> test() {
        return new ApiResponse<>("test");
    }

}
