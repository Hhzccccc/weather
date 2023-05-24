package com.shawnliang.core.utils;

import com.shawnliang.core.vo.ApiResponse;
import com.shawnliang.weather.common.exception.BaseException;
import com.shawnliang.weather.common.exception.IError;
import org.apache.commons.lang3.StringUtils;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/9
 */
public class ErrorCodeUtil {

    public static ApiResponse errorResponse() {
        return errorResponse(new BaseException());
    }

    /**
     * 构建错误响应
     *
     * @param baseException baseException
     * @return 错误响应
     */
    public static ApiResponse errorResponse(BaseException baseException) {
        return errorResponse(getErrorCode(baseException), baseException.getMessage());
    }

    /**
     * 获取错误码
     *
     * @param baseException 错误异常
     * @return 错误码
     */
    public static Integer getErrorCode(BaseException baseException) {
        int errorCode = 0;

        if (baseException == null) {
            baseException = new BaseException();
        }

        // 错误码不为0，则已拼接完成，直接返回
        if (baseException.getErrorCode() != 0) {
            return baseException.getErrorCode();
        }

        // 拼接错误码
        int systemNum = baseException.getSystemNum();
        String baseCode = StringUtils.leftPad(String.valueOf(baseException.getBaseCode()), 3, "0");
        errorCode = Integer
                .parseInt(StringUtils
                        .join(systemNum, baseException.getMidNum(),
                                baseCode));
        return errorCode;
    }


    public static ApiResponse errorResponse(IError iError) {
        return errorResponse(iError, iError.getDesc());
    }

    public static ApiResponse errorResponse(IError iError, String errorStr) {
        Integer errorCode = Integer
                .valueOf(StringUtils
                        .join(iError.getSystemNum(), iError.getMidNum(), iError.getBaseCode()));
        return errorResponse(errorCode, errorStr);
    }

    public static ApiResponse errorResponse(Integer errorCode, String errorStr) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setErrorCode(errorCode);
        apiResponse.setErrorStr(errorStr);
        return apiResponse;
    }


}
