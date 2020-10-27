package com.shawnliang.weather.common.model.resp.index;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/10/27
 */

@Data
public class BaseWeatherResp implements Serializable {

    private static final long serialVersionUID = 3408019538297682490L;

    @ApiModelProperty(value = "实时天气", dataType = "conditionResp", required = true)
    private WeatherConditionResp conditionResp;

    @ApiModelProperty(value = "24小时天气", dataType = "weather24HourResp", required = true)
    private Weather24HourResp weather24HourResp;

}
