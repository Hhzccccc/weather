package com.shawnliang.weather.common.model.resp.index;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * Description :   生活指数.
 *
 * @author : Phoebe
 * @date : Created in 2020/10/28
 */
@Data
public class WeatherLifeResp implements Serializable {

    private static final long serialVersionUID = 6252988264811807085L;

    @ApiModelProperty(required = true,dataType = "weatherLifeInfoRespList")
    private List<WeatherLifeInfoResp> weatherLifeInfoRespList;

    @Data
    @ApiModel
    public static class WeatherLifeInfoResp implements Serializable {

        private static final long serialVersionUID = 6723889767073526398L;

        @ApiModelProperty(value = "指数代码", example = "12")
        private String code;

        @ApiModelProperty(value = "day", example = "2020-10-08")
        private String day;

        @ApiModelProperty(value = "描述", example = "建议用露质面霜打底，水质无油粉底霜，透明粉饼，粉质胭脂")
        private String desc;

        @ApiModelProperty(value = "指数名称", example = "化妆指数")
        private String name;

        @ApiModelProperty(value = "状态", example = "控油")
        private String status;
    }


}
