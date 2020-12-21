package com.shawnliang.weather.common.model.req.ali;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/10/4
 */
@Data
public class AliWeatherBaseReq implements Serializable {

    private static final long serialVersionUID = -6082688757587864297L;

    @NotBlank(message = "请输入纬度！")
    @ApiModelProperty(value = "纬度", required = true, example = "31.150734")
    private String lat;

    @NotBlank(message = "请输入经度！")
    @ApiModelProperty(value = "经度", required = true, example = "121.124117")
    private String lng;
}
