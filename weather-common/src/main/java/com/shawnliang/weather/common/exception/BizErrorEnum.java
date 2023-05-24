package com.shawnliang.weather.common.exception;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/20
 */
@AllArgsConstructor
public enum BizErrorEnum implements IError {

    /**
     * 业务异常
     */
    ALI_WEATHER_ERROR(101, "第三方数据异常"),
    ;

    Integer baseCode;

    String desc;


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
        return Integer.valueOf(StringUtils.leftPad(String.valueOf(this.baseCode), 3, "0"));
    }
}
