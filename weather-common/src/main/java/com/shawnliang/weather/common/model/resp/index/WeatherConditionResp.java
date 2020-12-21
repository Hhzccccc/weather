package com.shawnliang.weather.common.model.resp.index;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
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

    @ApiModelProperty(value = "今明两天天气详情")
    private List<WeatherDetailResp> weatherDetailRespList;

    @Data
    @ApiModel("今明两天天气详情")
    public static class WeatherDetailResp implements Serializable {

        private static final long serialVersionUID = 4693042459167996377L;

        @ApiModelProperty(value = "日期描述", example = "今天 | 明天")
        private String dateDesc;

        @ApiModelProperty(value = "最高温度", example = "25")
        private Integer highTemp;

        @ApiModelProperty(value = "最低温度", example = "18")
        private Integer lowTemp;

        @ApiModelProperty(value = "天气详情", example = "多云")
        private String detailCondition;

        @ApiModelProperty(value = "空气质量描述", example = "良")
        private String detailAirDesc;

    }

}
