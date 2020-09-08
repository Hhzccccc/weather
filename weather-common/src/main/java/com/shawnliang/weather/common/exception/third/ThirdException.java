package com.shawnliang.weather.common.exception.third;

import com.shawnliang.weather.common.exception.BaseException;
import com.shawnliang.weather.common.model.IError;
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
public class ThirdException extends BaseException {

    private static final long serialVersionUID = -2993688559843854361L;

    public ThirdException(IError iError) {
        super(iError);
    }
}
