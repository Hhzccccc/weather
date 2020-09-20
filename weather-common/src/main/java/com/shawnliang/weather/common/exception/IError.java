package com.shawnliang.weather.common.exception;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/8
 */
public interface IError {

    /**
     * 获取基础编号
     * @return .
     */
    Integer getBaseCode();
    /**
     * 获取中间编号
     * @return .
     */
    default Integer getMidNum() {
        return 1;
    }

    /**
     * 获取系统编号
     * @return .
     */
    default Integer getSystemNum() {
        return 100;
    }

    /**
     * 获取异常编号
     * @return .
     */
    Integer getCode();

    /**
     * 获取异常描述
     * @return .
     */
    String getDesc();
}
