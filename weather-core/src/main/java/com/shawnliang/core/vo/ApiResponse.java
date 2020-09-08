package com.shawnliang.core.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/8
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> implements Serializable {

    private static final long serialVersionUID = -3339475068142688078L;

    @ApiModelProperty("错误码")
    private Integer errorCode = 0;

    @ApiModelProperty("错误描述")
    private String errorStr;

    @ApiModelProperty("结果")
    private T results;

    @ApiModelProperty("token")
    private String token;

    public ApiResponse(T results) {
        this.results = results;
    }
}
