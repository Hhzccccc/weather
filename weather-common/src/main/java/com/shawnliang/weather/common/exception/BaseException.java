package com.shawnliang.weather.common.exception;

import com.shawnliang.weather.common.model.CommonError;
import com.shawnliang.weather.common.model.IError;
import lombok.Data;

import java.io.Serializable;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/8
 */
@Data
public class BaseException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -9127943649747177054L;

    /**
     * base错误码
     */
    private int baseCode;

    /**
     * 错误信息
     */
    private String baseMsg;

    /**
     * 系统模块编号
     */
    private int systemNum;

    /**
     * 系统信息
     */
    private int midNum;

    /**
     * 总错误码
     */
    private int errorCode;

    public BaseException(String message, Throwable throwable) {
        super(message, throwable);
        this.baseCode = 0;
        this.baseMsg = "";
        this.midNum = 0;
        this.systemNum = 0;
        this.errorCode = 0;
        this.setBaseCode(CommonError.SYSTEM_ERROR.getCode());
        this.setBaseMsg(CommonError.SYSTEM_ERROR.getDesc());
        this.setMidNum(CommonError.SYSTEM_ERROR.getLayerNum());
        this.setSystemNum(CommonError.SYSTEM_ERROR.getSystemNum());
    }

    public BaseException(String message) {
        this(message, null);
    }


    public BaseException() {
        this(CommonError.SYSTEM_ERROR.getDesc());
    }

    public BaseException(Throwable throwable) {
        this(CommonError.SYSTEM_ERROR.getDesc(), throwable);
    }

    public BaseException(IError iError) {
        this(iError, iError.getDesc());
    }

    public BaseException(IError iError, String message) {
        this(iError, message, null);
    }

    public BaseException(IError iError, Throwable throwable) {
        this(iError, iError.getDesc(), throwable);
    }

    public BaseException(IError iError, String message, Throwable throwable) {
        super(message, throwable);
        this.baseCode = 0;
        this.baseMsg = "";
        this.midNum = 0;
        this.errorCode = 0;
        this.setBaseCode(iError.getCode());
        this.setBaseMsg(iError.getDesc());
        this.setMidNum(iError.getMidNum());
        this.setSystemNum(iError.getSystemNum());
    }

}
