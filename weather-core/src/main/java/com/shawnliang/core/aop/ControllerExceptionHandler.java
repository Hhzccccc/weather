package com.shawnliang.core.aop;

import com.shawnliang.core.utils.ErrorCodeUtil;
import com.shawnliang.core.vo.ApiResponse;
import com.shawnliang.weather.common.exception.CommonError;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/9
 */
@RestControllerAdvice
@Slf4j
public class ControllerExceptionHandler {


    /**
     * 自定义参数校验异常处理
     *
     * @param exception .
     *
     * @return .
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ApiResponse methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        log.info("自定义参数异常: {}", exception.getMessage());
        return  ErrorCodeUtil.errorResponse(CommonError.PARAM_ERROR,
                Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage());
    }

    /**
     * 参数校验异常
     *
     * @param exception 绑定校验异常
     *
     * @return .
     */
    @ExceptionHandler({BindException.class})
    public ApiResponse bindExceptionHandler(BindException exception) {
        log.info("参数异常: {}", exception.getMessage());
        return ErrorCodeUtil.errorResponse(CommonError.PARAM_ERROR,
                Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage());
    }


    @ExceptionHandler({ConstraintViolationException.class})
    public ApiResponse constraintViolationExceptionHandler(ConstraintViolationException exception) {
        log.info("自定义参数异常: {}", exception.getMessage());
        final List<String> errorList = new ArrayList<>(exception.getConstraintViolations().size());
        exception.getConstraintViolations().forEach(item -> {
            errorList.add(item.getMessageTemplate());
        });
        return ErrorCodeUtil.errorResponse(CommonError.PARAM_ERROR, StringUtils.join(errorList,"|"));
    }




    /**
     * 全局异常
     *
     * @param exception .
     *
     * @return .
     */
    @ExceptionHandler({Exception.class})
    public ApiResponse exceptionHandler(Exception exception) {
        log.info("全局异常[ERROR]: {}", exception.getMessage());
        log.error("全局异常: ", exception);
        return ErrorCodeUtil.errorResponse();
    }
}
