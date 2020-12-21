package com.shawnliang.weather.common.exception;

import lombok.Data;
import lombok.ToString;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/8
 */
@Data
@ToString(callSuper = true)
public class BusinessException extends BaseException {

    private static final long serialVersionUID = -2993688559843854361L;

    public BusinessException(IError iError) {
        super(iError);
    }

    public BusinessException(IError iError, String msg) {
        super(iError, msg);
    }
}
