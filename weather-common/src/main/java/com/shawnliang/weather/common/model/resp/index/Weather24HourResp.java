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
 * @date : Created in 2020/10/27
 */
@Data
public class Weather24HourResp implements Serializable {

    private static final long serialVersionUID = 2308991387513437918L;

    @ApiModelProperty(value = "24小时天气", required = true)
    public List<Weather24HourInfoResp> weather24HourInfoRespList;

    @ApiModelProperty(value = "最高温度", example = "20", required = true)
    private String highTemp;

    @ApiModelProperty(value = "最低温度", example = "10", required = true)
    private String lowTemp;

    @ApiModelProperty(value = "日出时间", example = "05:54")
    private String sunRise;

    @ApiModelProperty(value = "日落时间", example = "17:33")
    private String sunSet;

    @Data
    @ApiModel
    public static class Weather24HourInfoResp implements Serializable {

        private static final long serialVersionUID = -3916148308801573872L;

        @ApiModelProperty(value = "小时", example = "20:00")
        private String time;

        @ApiModelProperty(value = "天气状况", example = "晴")
        private String condition;

        @ApiModelProperty(value = "实时温度", example = "25")
        private String temp;

        @ApiModelProperty(value = "风级别", example = "1")
        private String windLevel;

        @ApiModelProperty(value = "空气质量数值", example = "25")
        private Integer airValue;

        @ApiModelProperty(value = "实时温度", example = "25")
        private String airDesc;
    }
}
