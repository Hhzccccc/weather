package com.shawnliang.weather.common.model;

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
    default int getBaseCode() {
        return 1;
    }

    /**
     * 获取中间编号
     * @return .
     */
    default int getMidNum() {
        return 1;
    }

    /**
     * 获取系统编号
     * @return .
     */
    default int getSystemNum() {
        return 100;
    }

    /**
     * 获取异常编号
     * @return .
     */
    int getCode();

    /**
     * 获取异常描述
     * @return .
     */
    String getDesc();
}
