package com.shawnliang.weather.common.logger;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/8
 */
public class LogBackExEncoder extends PatternLayoutEncoder {

    static {
        PatternLayout.defaultConverterMap.put("T", ThreadNumConverter.class.getName());
    }
}
