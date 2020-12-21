package com.shawnliang.weather.common.model.resp.ali;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel
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
            @ApiModelProperty(value = "实时天气", example = "晴")
            private String condition;

            @ApiModelProperty(value = "实时天气id", example = "82")
            private String conditionId;

            @ApiModelProperty(value = "湿度", example = "70")
            private String humidity;

            @ApiModelProperty(value = "天气icon", example = "31")
            private String icon;

            @ApiModelProperty(value = "气压", example = "1024")
            private String pressure;

            @ApiModelProperty(value = "体感温度", example = "20")
            private String realFeel;

            @ApiModelProperty(value = "日出时间", example = "2020-10-08 05:54:00")
            private String sunRise;

            @ApiModelProperty(value = "日落时间", example = "2020-10-08 17:33:00")
            private String sunSet;

            @ApiModelProperty(value = "温度", example = "19")
            private String temp;

            @ApiModelProperty(value = "一句话提示", example = "略微偏凉，还是蛮舒适的。")
            private String tips;

            @ApiModelProperty(value = "发布时间", example = "2020-10-08 21:15:08")
            private String updatetime;

            @ApiModelProperty(value = "紫外线强度", example = "1")
            private String uvi;

            @ApiModelProperty(value = "风向", example = "北风")
            private String windDir;

            @ApiModelProperty(value = "风速", example = "4")
            private String windLevel;

            @ApiModelProperty(value = "风速", example = "6.2")
            private String windSpeed;
        }
    }
}
