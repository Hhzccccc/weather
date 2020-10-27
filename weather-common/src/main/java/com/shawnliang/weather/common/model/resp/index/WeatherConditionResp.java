package com.shawnliang.weather.common.model.resp.index;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/10/28
 */
@Data
@ApiModel("实时天气")
public class WeatherConditionResp implements Serializable {

    private static final long serialVersionUID = -5564838677867353847L;

    @ApiModelProperty(value = "温度", example = "19")
    private String temp;

    @ApiModelProperty(value = "实时天气", example = "雷阵雨")
    private String condition;

    @ApiModelProperty(value = "风向", example = "东北风")
    private String windDir;

    @ApiModelProperty(value = "风速", example = "4")
    private String windLevel;

    @ApiModelProperty(value = "湿度", example = "70")
    private String humidity;

    @ApiModelProperty(value = "一句话提示", example = "略微偏凉，还是蛮舒适的。")
    private String tips;

    @ApiModelProperty(value = "空气质量指数", example = "70")
    private String airValue;

    @ApiModelProperty(value = "空气质量描述", example = "良")
    private String airDesc;

}
