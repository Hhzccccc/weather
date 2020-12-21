package com.shawnliang.weather.common.filter;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.MDC;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/11/21
 */
@Slf4j
public class GlobalFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        RequestContextA requestContext = RequestContextA.getContext();
        String traceId = UUID.randomUUID().toString();
        MDC.put("TRACE_ID", traceId);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        requestContext.addContextDetail("TRACE_ID", traceId);
        chain.doFilter(servletRequest, response);
        stopWatch.stop();
        log.info("请求耗时：{}ms", stopWatch.getTime(TimeUnit.MILLISECONDS));
        log.debug("整个请求处理完毕清除 logback MDC");
        MDC.clear();
        RequestContextA.clear();
    }
}
