package com.shawnliang.core.component;

import com.google.common.collect.Lists;
import com.shawnliang.weather.common.model.enums.WeatherAqiEnum;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/10/27
 */
public class WeatherConvertComponent {

    private static List<Integer> airValue = Lists.newCopyOnWriteArrayList();

    private Map<Integer, String> aqiDescMap = new ConcurrentHashMap<>(32);


    public static String getAqiDesc(Integer value) {
        int i = value;
        if (i >= 0 && i <= 50) {
            return WeatherAqiEnum.EXCELLENT.getDesc();
        } else if (i >= 51 && i <= 100) {
            return WeatherAqiEnum.GOOD.getDesc();
        } else if (i >= 101 && i <= 150) {
            return WeatherAqiEnum.LIGHT.getDesc();
        } else if (i >= 151 && i<= 200) {
            return WeatherAqiEnum.MID.getDesc();
        } else if (i >= 201 && i<= 300) {
            return WeatherAqiEnum.HEAVY.getDesc();
        } else if (i >= 301 && i<= 500) {
            return WeatherAqiEnum.SERIOUS.getDesc();
        } else if (i >= 501) {
            return WeatherAqiEnum.BURST.getDesc();
        } else {
            return WeatherAqiEnum.OTHER.getDesc();
        }
    }

    public static Integer getWindLevelBySpeed(double windSpeed) {
        if (windSpeed >= 0.0 && windSpeed <= 0.2) {
            return 0;
        } else if (windSpeed > 0.2 && windSpeed <= 1.5) {
            return 1;
        } else if (windSpeed > 1.5 && windSpeed <= 3.3) {
            return 2;
        }else if (windSpeed > 3.3 && windSpeed <= 5.4) {
            return 3;
        } else if (windSpeed > 5.4 && windSpeed <= 7.9) {
            return 4;
        } else if (windSpeed > 7.9 && windSpeed <= 10.7) {
            return 5;
        } else if (windSpeed > 10.7 && windSpeed <= 13.8) {
            return 6;
        } else if (windSpeed > 13.8 && windSpeed <= 17.1) {
            return 7;
        } else if (windSpeed > 17.1 && windSpeed <= 20.7) {
            return 8;
        } else if (windSpeed > 20.7 && windSpeed <= 24.4) {
            return 9;
        } else if (windSpeed > 24.4 && windSpeed <= 28.4) {
            return 10;
        }  else if (windSpeed > 28.4 && windSpeed <= 32.6) {
            return 11;
        } else if (windSpeed > 32.6 && windSpeed <= 36.9) {
            return 12;
        } else if (windSpeed > 36.9 && windSpeed <= 41.4) {
            return 13;
        } else if (windSpeed > 41.4 && windSpeed <= 46.1) {
            return 14;
        } else if (windSpeed > 46.1 && windSpeed <= 50.9) {
            return 15;
        } else if (windSpeed > 50.9 && windSpeed <= 56.0) {
            return 16;
        } else if (windSpeed > 56.0 && windSpeed <= 61.2) {
            return 17;
        } else {
            return 18;
        }

    }


}
