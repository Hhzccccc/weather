package com.shawnliang.weather.common.model.resp.ali;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/20
 */
@Data
public class AliMojiWeatherBaseResp implements Serializable {

    private static final long serialVersionUID = 8438838311298713025L;

    /**
     * 0:正常请求 1:token异常 2:签名错误 10:经纬度超限
     */
    @ApiModelProperty(example = "0", value = "0", notes = "阿里墨迹错误码",required = true)
    private Integer code;

    /**
     * errString
     */
    @ApiModelProperty(example = "success", value = "success", notes = "阿里墨迹errString",required = true)
    private String msg;


    private RcEntity rcEntity;

    @Data
    @ApiModel("返回码实体类")
    public static class RcEntity {
        /**
         * p : success
         * c : 0
         */
        @ApiModelProperty(example = "success", value = "success", notes = "errString",required = true)
        private String p;

        @ApiModelProperty(example = "0", value = "0", notes = "code",required = true)
        private int c;

    }
}
