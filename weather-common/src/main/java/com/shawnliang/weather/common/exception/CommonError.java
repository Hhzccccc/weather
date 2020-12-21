package com.shawnliang.weather.common.exception;

import lombok.Getter;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/8
 */
@Getter
public enum CommonError implements IError {

    /**
     * 枚举错误码
     */
    COMMON_BIZ_ERROR(101, "通用异常"),
    PARAM_ERROR(102, "参数错误"),
    SYSTEM_ERROR(999, "系统异常"),
    ;

    CommonError(Integer baseCode, String desc) {
        this.baseCode = baseCode;
        this.desc = desc;
    }

    private Integer baseCode;
    private String desc;

    public int getLayerNum() {
        return 0;
    }

    @Override
    public Integer getSystemNum() {
        return 101;
    }

    @Override
    public Integer getCode() {
        return this.baseCode;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }

    @Override
    public Integer getBaseCode() {
        return baseCode;
    }
}
