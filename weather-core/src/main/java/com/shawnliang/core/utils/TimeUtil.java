package com.shawnliang.core.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.lang3.StringUtils;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/10/27
 */
public class TimeUtil {

    public static LocalDateTime formatTimeFromString(String timeStr, String formatter) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(formatter);
        return LocalDateTime.parse(timeStr, df);
    }

    public static String formatFromDateTime(LocalDateTime dateTime, String formatter) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(formatter);
        return dateTime.format(df);
    }

    public static LocalDate formatDateFromString(String timeStr, String formatter) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(formatter);
        return LocalDate.parse(timeStr, df);
    }

    public static String formatFromDate(LocalDate localDate, String formatter) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(formatter);
        return localDate.format(df);
    }


    public static String getDateDesc(LocalDate date) {
        if (date == null) {
            return StringUtils.EMPTY;
        }
        LocalDateTime now = LocalDateTime.now();
        if (date.isBefore(now.toLocalDate())) {
            return "昨天";
        }
        else if (date.equals(now.toLocalDate())) {
            return "今天";
        }
        else if (date.minusDays(1).equals(now.toLocalDate())) {
            return "明天";
        } else {
            return getDayWeekDesc(date);
        }
    }

    private static String getDayWeekDesc(LocalDate localDate) {
        int value = localDate.getDayOfWeek().getValue();
        if (value == 1) {
            return "周一";
        } else if (value == 2) {
            return "周二";
        } else if (value == 3) {
            return "周三";
        } else if (value == 4) {
            return "周四";
        } else if (value == 5) {
            return "周五";
        } else if (value == 6) {
            return "周六";
        } else {
            return "周日";
        }
    }

}
