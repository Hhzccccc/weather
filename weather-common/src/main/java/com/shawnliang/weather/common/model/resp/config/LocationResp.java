package com.shawnliang.weather.common.model.resp.config;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
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
}
