package com.shawnliang.core.aop;

import com.shawnliang.core.vo.ApiResponse;
import com.shawnliang.core.utils.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import javax.servlet.http.HttpServletRequest;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/9
 */
@Aspect
@Order(1)
@Slf4j
public class ControllerInterceptor {

    @Autowired
    private HttpServletRequest request;

    /**
     * 拦截所有的controller方法
     */
    @Pointcut("execution (* com.shawnliang.*.controller..*Controller.*(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object interceptor(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature methodSignature = ((MethodSignature) pjp.getSignature());
        long start = System.currentTimeMillis();
        // 前置打印日志
        beforeLog(pjp);

        Object result = pjp.proceed();
        if (result instanceof ApiResponse) {
            ApiResponse apiResponse = (ApiResponse) result;
            result = apiResponse;
        }

        // 后置打印log
        afterLog(pjp, result, start);

        return result;
    }

    /**
     * 打印log的前置
     * @param pjp .
     */
    private void beforeLog(ProceedingJoinPoint pjp) {

        try {
            String className = pjp.getTarget().getClass().getSimpleName();
            String methodName = pjp.getSignature().getName();
            Signature signature = pjp.getSignature();
            MethodSignature methodSignature = (MethodSignature) signature;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("uri[").append(request.getRequestURI()).append("], ");
            stringBuilder.append("ip[").append(IpUtil.getRequestIp(request)).append("], ");
            stringBuilder.append("method[").append(className).append(".").append(methodName)
                    .append("] ");

            for (int i = 0; i < pjp.getArgs().length; i++) {
                stringBuilder.append("参数名:");
                stringBuilder.append(methodSignature.getParameterNames()[i]);
                stringBuilder.append(",参数值:");
                stringBuilder.append(pjp.getArgs()[i]);
            }
            log.info(stringBuilder.toString());
        } catch (Exception e) {
            log.error("打印日志异常", e);
        }
    }

    /**
     * 拦截器后打LOG的工具类
     *
     * @param pjp
     */
    private void afterLog(ProceedingJoinPoint pjp, Object result, long startMiles) {
        try {
            String className = pjp.getTarget().getClass().getSimpleName();
            String methodName = pjp.getSignature().getName();
            log.info(StringUtils.join("method[",
                    className, ".", methodName, "],"
                            + " 结果为: "));
            log.debug("AOP耗时 {}", System.currentTimeMillis() - startMiles);
        } catch (Exception e) {
            log.error("打印日志异常", e);
        }
    }

}
