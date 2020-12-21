package com.shawnliang.core.utils;

import com.google.common.collect.Maps;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/10/27
 */
public class TimeUtil {

    private static final Map<Integer, String> chineseMap = Maps.newConcurrentMap();

    static {
        chineseMap.put(1, "一");
        chineseMap.put(2, "二");
        chineseMap.put(3, "三");
        chineseMap.put(4, "四");
        chineseMap.put(5, "五");
        chineseMap.put(6, "六");
        chineseMap.put(7, "七");
        chineseMap.put(8, "八");
        chineseMap.put(9, "九");
        chineseMap.put(10, "十");
        chineseMap.put(11, "十一");
        chineseMap.put(12, "十二");
    }

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

    public static String toChineseDateString(String dateString) {
        if (StringUtils.isBlank(dateString)) {
            return dateString;
        }

        int index = StringUtils.indexOf(dateString, "月");
        if (index - 1 < 0) {
            return dateString;
        }
        String month = StringUtils.substring(dateString, 0, index - 1);
        return StringUtils
                .replaceOnce(dateString, month, chineseMap.get(Integer.parseInt(month)));

    }

    public static final String getMonthChinese(Integer monthValue) {
        return chineseMap.get(monthValue);
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

    public static String getDayWeekDesc(LocalDate localDate) {
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
