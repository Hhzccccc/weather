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
@ApiModel
public class Weather15DaysResp implements Serializable {

    private static final long serialVersionUID = 4470169835597994774L;

    @ApiModelProperty(value = "15天详情",required = true)
    private List<Weather15InfoResp> weather15InfoRespList;

    @Data
    public static class Weather15InfoResp implements Serializable {

        private static final long serialVersionUID = -7649906172507598267L;

        @ApiModelProperty(value = "最高气温", example = "25")
        private Integer lowTemp;

        @ApiModelProperty(value = "最低气温", example = "10")
        private Integer highTemp;

        @ApiModelProperty(value = "日期", example = "10/25")
        private String date;

        @ApiModelProperty(value = "日期描述", example = "昨日")
        private String dateDesc;

        @ApiModelProperty(value = "白天天气", example = "少云")
        private String conditionDay;

        @ApiModelProperty(value = "白天天气id", example = "2")
        private String conditionIdDay;

        @ApiModelProperty(value = "夜间天气id", example = "1")
        private String conditionIdNight;

        @ApiModelProperty(value = "夜间天气", example = "多云")
        private String conditionNight;

        @ApiModelProperty(value = "风向描述", example = "1-2级")
        private String windDesc;

        @ApiModelProperty(value = "空气质量指数", example = "70")
        private String airValue;

        @ApiModelProperty(value = "空气质量描述", example = "良")
        private String airDesc;
    }
}
