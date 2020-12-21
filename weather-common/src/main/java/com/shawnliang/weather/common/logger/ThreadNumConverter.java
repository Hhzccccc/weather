package com.shawnliang.weather.common.logger;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * Description :  线程号转换类 .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/8
 */
public class ThreadNumConverter extends ClassicConverter {

    @Override
    public String convert(ILoggingEvent event) {
        return String.valueOf(Thread.currentThread().getId());
    }
}
