package com.shawnliang.weather.common.model.resp.ali;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   阿里墨迹——天气实况.
 * @url whapi/json/alicityweather/condition
 "code": 0,
 "data": {
 "city": {
 "cityId": 284609,
 "counname": "中国",
 "name": "东城区",
 "pname": "北京市"
 },
 "condition": {
 "condition": "晴",
 "conditionId": "5",
 "humidity": "42",
 "icon": "30",
 "pressure": "999",
 "realFeel": "18",
 "sunRise": "2016-09-01 05:42:00",
 "sunSet": "2016-09-01 18:45:00",
 "temp": "24",
 "tips": "冷热适宜，感觉很舒适。",
 "updatetime": "2016-09-01 22:03:00",
 "uvi": "0",
 "windDir": "东北风",
 "windLevel": "2",
 "windSpeed": "2.45"
 }
 },
 "msg": "success",
 "rc": {
 "c": 0,
 "p": "success"
 }
 }
 * @author : Phoebe
 * @date : Created in 2020/9/20
 */
@Data
@ToString(callSuper = true)
public class AliMojiConditionNowResp extends AliMojiWeatherBaseResp {

    private static final long serialVersionUID = 1717343741011457065L;

    /**
     * data : {"city":{"cityId":284609,"counname":"中国","name":"东城区","pname":"北京市"},"condition":{"condition":"晴","conditionId":"5","humidity":"42","icon":"30","pressure":"999","realFeel":"18","sunRise":"2016-09-01 05:42:00","sunSet":"2016-09-01 18:45:00","temp":"24","tips":"冷热适宜，感觉很舒适。","updatetime":"2016-09-01 22:03:00","uvi":"0","windDir":"东北风","windLevel":"2","windSpeed":"2.45"}}
     * rc : {"c":0,"p":"success"}
     */
    private DataBean data;

    @Data
    public static class DataBean implements Serializable {

        private static final long serialVersionUID = -2321098167343072179L;

        /**
         * city : {"cityId":284609,"counname":"中国","name":"东城区","pname":"北京市"}
         * condition : {"condition":"晴","conditionId":"5","humidity":"42","icon":"30","pressure":"999","realFeel":"18","sunRise":"2016-09-01 05:42:00","sunSet":"2016-09-01 18:45:00","temp":"24","tips":"冷热适宜，感觉很舒适。","updatetime":"2016-09-01 22:03:00","uvi":"0","windDir":"东北风","windLevel":"2","windSpeed":"2.45"}
         */

        private AliMojiCityBean city;
        private ConditionBean condition;

        @Data
        public static class ConditionBean implements Serializable {

            private static final long serialVersionUID = -1165259913985963077L;

            /**
             * condition : 晴
             * conditionId : 5
             * humidity : 42
             * icon : 30
             * pressure : 999
             * realFeel : 18
             * sunRise : 2016-09-01 05:42:00
             * sunSet : 2016-09-01 18:45:00
             * temp : 24
             * tips : 冷热适宜，感觉很舒适。
             * updatetime : 2016-09-01 22:03:00
             * uvi : 0
             * windDir : 东北风
             * windLevel : 2
             * windSpeed : 2.45
             */

            private String condition;
            private String conditionId;
            private String humidity;
            private String icon;
            private String pressure;
            private String realFeel;
            private String sunRise;
            private String sunSet;
            private String temp;
            private String tips;
            private String updatetime;
            private String uvi;
            private String windDir;
            private String windLevel;
            private String windSpeed;
        }
    }
}
