package com.shawnliang.weather.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/8
 */
@AllArgsConstructor
@Getter
public enum CommonError implements IError {

    /**
     * 枚举错误码
     */
    COMMON_BIZ_ERROR(101, "通用异常"),
    PARAM_ERROR(102, "参数错误"),
    SYSTEM_ERROR(999, "系统异常"),
    ;

    private int baseCode;
    private String desc;

    public int getLayerNum() {
        return 0;
    }

    @Override
    public int getSystemNum() {
        return 101;
    }

    @Override
    public int getCode() {
        return this.baseCode;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }
}
