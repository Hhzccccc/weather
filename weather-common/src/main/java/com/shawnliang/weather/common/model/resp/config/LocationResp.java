package com.shawnliang.weather.common.model.resp.config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/10/8
 */
@Data
public class LocationResp implements Serializable {

    private static final long serialVersionUID = 965636951441104960L;

    @ApiModelProperty(value = "地区名称", required = true, example = "徐汇区")
    private String districtName;

    @ApiModelProperty(required = true)
    private DateInfoResp dateInfoResp;

    @Data
    @Builder
    @ApiModel
    public static class DateInfoResp implements Serializable {

        private static final long serialVersionUID = -4718309367341865818L;

        @ApiModelProperty(value = "日期描述", required = true, example = "九月18")
        private String dateDesc;

        @ApiModelProperty(value = "周几", required = true, example = "周六")
        private String weekDesc;

        @ApiModelProperty(value = "农历", required = true, example = "八月初四")
        private String chineseDateDesc;
    }
}
