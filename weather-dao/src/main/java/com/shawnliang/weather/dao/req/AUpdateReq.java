package com.shawnliang.weather.dao.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/13
 */
@Data
@ApiModel("更新对象")
public class AUpdateReq implements Serializable {

    private static final long serialVersionUID = 8216348878751563002L;

    @ApiModelProperty(value = "1", required = true, example = "3")
    @NotNull(message = "请输入ID")
    private Long id;

    @ApiModelProperty(value = "张三")
    @NotBlank(message = "请输入姓名")
    private String userName;
}
