package com.shawnliang.weather.common.model.resp.ali;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   阿里墨迹——天气预报15天.
 * @url /whapi/json/alicityweather/forecast15days
 * @author : Phoebe
 * @date : Created in 2020/9/20
 */
@Data
@ToString(callSuper = true)
@ApiModel
public class AliMojiForecast15DaysResp extends AliMojiWeatherBaseResp {

    private static final long serialVersionUID = 2403849187741672550L;

    /**
     * data : {"city":{"cityId":284609,"counname":"中国","name":"东城区","pname":"北京市"},"forecast":[{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"多云","moonphase":"WaningCrescent","moonrise":"2016-08-31 04:19:00","moonset":"2016-08-31 18:07:00","predictDate":"2016-08-31","sunrise":"2016-08-31 05:41:00","sunset":"2016-08-31 18:47:00","tempDay":"34","tempNight":"18","updatetime":"2016-08-31 23:07:06","windDirDay":"北风","windDirNight":"西北风","windLevelDay":"3","windLevelNight":"3","windSpeedDay":"5.0","windSpeedNight":"5.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"多云","moonphase":"New","moonrise":"2016-09-01 05:20:00","moonset":"2016-09-01 18:41:00","predictDate":"2016-09-01","sunrise":"2016-09-01 05:42:00","sunset":"2016-09-01 18:45:00","tempDay":"27","tempNight":"18","updatetime":"2016-09-01 22:07:06","windDirDay":"西北风","windDirNight":"北风","windLevelDay":"3","windLevelNight":"2","windSpeedDay":"5.0","windSpeedNight":"3.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"多云","moonphase":"WaxingCrescent","moonrise":"2016-09-02 06:20:00","moonset":"2016-09-02 19:14:00","predictDate":"2016-09-02","sunrise":"2016-09-02 05:43:00","sunset":"2016-09-02 18:44:00","tempDay":"27","tempNight":"20","updatetime":"2016-09-01 22:07:06","windDirDay":"西北风","windDirNight":"东南风","windLevelDay":"2","windLevelNight":"2","windSpeedDay":"3.0","windSpeedNight":"3.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"多云","moonphase":"WaxingCrescent","moonrise":"2016-09-03 07:19:00","moonset":"2016-09-03 19:44:00","predictDate":"2016-09-03","sunrise":"2016-09-03 05:44:00","sunset":"2016-09-03 18:42:00","tempDay":"28","tempNight":"20","updatetime":"2016-09-01 22:07:06","windDirDay":"东南风","windDirNight":"东南风","windLevelDay":"2","windLevelNight":"2","windSpeedDay":"3.0","windSpeedNight":"3.0"},{"conditionDay":"阵雨","conditionIdDay":"3","conditionIdNight":"30","conditionNight":"大部晴朗","moonphase":"WaxingCrescent","moonrise":"2016-09-04 08:16:00","moonset":"2016-09-04 20:14:00","predictDate":"2016-09-04","sunrise":"2016-09-04 05:45:00","sunset":"2016-09-04 18:41:00","tempDay":"28","tempNight":"18","updatetime":"2016-09-01 22:07:06","windDirDay":"南风","windDirNight":"西风","windLevelDay":"2","windLevelNight":"2","windSpeedDay":"3.0","windSpeedNight":"3.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"少云","moonphase":"WaxingCrescent","moonrise":"2016-09-05 09:13:00","moonset":"2016-09-05 20:44:00","predictDate":"2016-09-05","sunrise":"2016-09-05 05:46:00","sunset":"2016-09-05 18:39:00","tempDay":"30","tempNight":"21","updatetime":"2016-09-01 22:07:06","windDirDay":"西北风","windDirNight":"西北风","windLevelDay":"2","windLevelNight":"2","windSpeedDay":"3.0","windSpeedNight":"3.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"多云","moonphase":"WaxingCrescent","moonrise":"2016-09-06 10:08:00","moonset":"2016-09-06 21:16:00","predictDate":"2016-09-06","sunrise":"2016-09-06 05:47:00","sunset":"2016-09-06 18:37:00","tempDay":"30","tempNight":"21","updatetime":"2016-09-01 22:07:06","windDirDay":"北风","windDirNight":"北风","windLevelDay":"2","windLevelNight":"2","windSpeedDay":"3.0","windSpeedNight":"3.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"少云","moonphase":"WaxingCrescent","moonrise":"2016-09-07 11:04:00","moonset":"2016-09-07 21:50:00","predictDate":"2016-09-07","sunrise":"2016-09-07 05:48:00","sunset":"2016-09-07 18:36:00","tempDay":"27","tempNight":"17","updatetime":"2016-09-01 22:07:06","windDirDay":"西风","windDirNight":"东北风","windLevelDay":"2","windLevelNight":"2","windSpeedDay":"3.0","windSpeedNight":"3.0"},{"conditionDay":"阵雨","conditionIdDay":"3","conditionIdNight":"33","conditionNight":"阵雨","moonphase":"WaxingCrescent","moonrise":"2016-09-08 11:59:00","moonset":"2016-09-08 22:27:00","predictDate":"2016-09-08","sunrise":"2016-09-08 05:49:00","sunset":"2016-09-08 18:34:00","tempDay":"31","tempNight":"17","updatetime":"2016-09-01 22:07:06","windDirDay":"东南风","windDirNight":"北风","windLevelDay":"1","windLevelNight":"1","windSpeedDay":"1.0","windSpeedNight":"1.0"},{"conditionDay":"局部阵雨","conditionIdDay":"3","conditionIdNight":"30","conditionNight":"晴","moonphase":"First","moonrise":"2016-09-09 12:53:00","moonset":"2016-09-09 23:09:00","predictDate":"2016-09-09","sunrise":"2016-09-09 05:50:00","sunset":"2016-09-09 18:33:00","tempDay":"31","tempNight":"18","updatetime":"2016-09-01 22:07:06","windDirDay":"东风","windDirNight":"南风","windLevelDay":"1","windLevelNight":"2","windSpeedDay":"1.0","windSpeedNight":"3.0"},{"conditionDay":"雷阵雨","conditionIdDay":"4","conditionIdNight":"33","conditionNight":"阵雨","moonphase":"WaxingGibbous","moonrise":"2016-09-10 13:45:00","moonset":"2016-09-10 23:55:00","predictDate":"2016-09-10","sunrise":"2016-09-10 05:51:00","sunset":"2016-09-10 18:31:00","tempDay":"31","tempNight":"18","updatetime":"2016-09-01 22:07:06","windDirDay":"东北风","windDirNight":"东风","windLevelDay":"1","windLevelNight":"2","windSpeedDay":"1.0","windSpeedNight":"3.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"多云","moonphase":"WaxingGibbous","moonrise":"2016-09-11 14:35:00","moonset":"2016-09-12 00:46:00","predictDate":"2016-09-11","sunrise":"2016-09-11 05:52:00","sunset":"2016-09-11 18:29:00","tempDay":"31","tempNight":"20","updatetime":"2016-09-01 22:07:06","windDirDay":"西南风","windDirNight":"北风","windLevelDay":"2","windLevelNight":"1","windSpeedDay":"3.0","windSpeedNight":"1.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"多云","moonphase":"WaxingGibbous","moonrise":"2016-09-12 15:24:00","moonset":"2016-09-13 01:43:00","predictDate":"2016-09-12","sunrise":"2016-09-12 05:53:00","sunset":"2016-09-12 18:28:00","tempDay":"31","tempNight":"20","updatetime":"2016-09-01 22:07:06","windDirDay":"南风","windDirNight":"西南风","windLevelDay":"1","windLevelNight":"1","windSpeedDay":"1.0","windSpeedNight":"1.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"少云","moonphase":"WaxingGibbous","moonrise":"2016-09-13 16:08:00","moonset":"2016-09-14 02:44:00","predictDate":"2016-09-13","sunrise":"2016-09-13 05:54:00","sunset":"2016-09-13 18:26:00","tempDay":"31","tempNight":"20","updatetime":"2016-09-01 22:07:06","windDirDay":"东北风","windDirNight":"西北风","windLevelDay":"1","windLevelNight":"2","windSpeedDay":"1.0","windSpeedNight":"3.0"},{"conditionDay":"阵雨","conditionIdDay":"3","conditionIdNight":"33","conditionNight":"阵雨","moonphase":"WaxingGibbous","moonrise":"2016-09-14 16:50:00","moonset":"2016-09-15 03:50:00","predictDate":"2016-09-14","sunrise":"2016-09-14 05:55:00","sunset":"2016-09-14 18:24:00","tempDay":"31","tempNight":"20","updatetime":"2016-09-01 22:07:06","windDirDay":"南风","windDirNight":"东风","windLevelDay":"2","windLevelNight":"1","windSpeedDay":"3.0","windSpeedNight":"1.0"},{"conditionDay":"晴","conditionIdDay":"0","conditionIdNight":"31","conditionNight":"多云","moonphase":"WaxingGibbous","moonrise":"2016-09-15 17:30:00","moonset":"2016-09-16 04:57:00","predictDate":"2016-09-15","sunrise":"2016-09-15 05:55:00","sunset":"2016-09-15 18:23:00","tempDay":"31","tempNight":"18","updatetime":"2016-09-01 22:07:06","windDirDay":"西风","windDirNight":"西风","windLevelDay":"1","windLevelNight":"2","windSpeedDay":"1.0","windSpeedNight":"3.0"}]}
     * rc : {"c":0,"p":"success"}
     */

    private DataBean data;

    @Data
    @ApiModel
    public static class DataBean implements Serializable {

        private static final long serialVersionUID = 1592280910217500544L;

        /**
         * city : {"cityId":284609,"counname":"中国","name":"东城区","pname":"北京市"}
         * forecast : [{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"多云","moonphase":"WaningCrescent","moonrise":"2016-08-31 04:19:00","moonset":"2016-08-31 18:07:00","predictDate":"2016-08-31","sunrise":"2016-08-31 05:41:00","sunset":"2016-08-31 18:47:00","tempDay":"34","tempNight":"18","updatetime":"2016-08-31 23:07:06","windDirDay":"北风","windDirNight":"西北风","windLevelDay":"3","windLevelNight":"3","windSpeedDay":"5.0","windSpeedNight":"5.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"多云","moonphase":"New","moonrise":"2016-09-01 05:20:00","moonset":"2016-09-01 18:41:00","predictDate":"2016-09-01","sunrise":"2016-09-01 05:42:00","sunset":"2016-09-01 18:45:00","tempDay":"27","tempNight":"18","updatetime":"2016-09-01 22:07:06","windDirDay":"西北风","windDirNight":"北风","windLevelDay":"3","windLevelNight":"2","windSpeedDay":"5.0","windSpeedNight":"3.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"多云","moonphase":"WaxingCrescent","moonrise":"2016-09-02 06:20:00","moonset":"2016-09-02 19:14:00","predictDate":"2016-09-02","sunrise":"2016-09-02 05:43:00","sunset":"2016-09-02 18:44:00","tempDay":"27","tempNight":"20","updatetime":"2016-09-01 22:07:06","windDirDay":"西北风","windDirNight":"东南风","windLevelDay":"2","windLevelNight":"2","windSpeedDay":"3.0","windSpeedNight":"3.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"多云","moonphase":"WaxingCrescent","moonrise":"2016-09-03 07:19:00","moonset":"2016-09-03 19:44:00","predictDate":"2016-09-03","sunrise":"2016-09-03 05:44:00","sunset":"2016-09-03 18:42:00","tempDay":"28","tempNight":"20","updatetime":"2016-09-01 22:07:06","windDirDay":"东南风","windDirNight":"东南风","windLevelDay":"2","windLevelNight":"2","windSpeedDay":"3.0","windSpeedNight":"3.0"},{"conditionDay":"阵雨","conditionIdDay":"3","conditionIdNight":"30","conditionNight":"大部晴朗","moonphase":"WaxingCrescent","moonrise":"2016-09-04 08:16:00","moonset":"2016-09-04 20:14:00","predictDate":"2016-09-04","sunrise":"2016-09-04 05:45:00","sunset":"2016-09-04 18:41:00","tempDay":"28","tempNight":"18","updatetime":"2016-09-01 22:07:06","windDirDay":"南风","windDirNight":"西风","windLevelDay":"2","windLevelNight":"2","windSpeedDay":"3.0","windSpeedNight":"3.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"少云","moonphase":"WaxingCrescent","moonrise":"2016-09-05 09:13:00","moonset":"2016-09-05 20:44:00","predictDate":"2016-09-05","sunrise":"2016-09-05 05:46:00","sunset":"2016-09-05 18:39:00","tempDay":"30","tempNight":"21","updatetime":"2016-09-01 22:07:06","windDirDay":"西北风","windDirNight":"西北风","windLevelDay":"2","windLevelNight":"2","windSpeedDay":"3.0","windSpeedNight":"3.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"多云","moonphase":"WaxingCrescent","moonrise":"2016-09-06 10:08:00","moonset":"2016-09-06 21:16:00","predictDate":"2016-09-06","sunrise":"2016-09-06 05:47:00","sunset":"2016-09-06 18:37:00","tempDay":"30","tempNight":"21","updatetime":"2016-09-01 22:07:06","windDirDay":"北风","windDirNight":"北风","windLevelDay":"2","windLevelNight":"2","windSpeedDay":"3.0","windSpeedNight":"3.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"少云","moonphase":"WaxingCrescent","moonrise":"2016-09-07 11:04:00","moonset":"2016-09-07 21:50:00","predictDate":"2016-09-07","sunrise":"2016-09-07 05:48:00","sunset":"2016-09-07 18:36:00","tempDay":"27","tempNight":"17","updatetime":"2016-09-01 22:07:06","windDirDay":"西风","windDirNight":"东北风","windLevelDay":"2","windLevelNight":"2","windSpeedDay":"3.0","windSpeedNight":"3.0"},{"conditionDay":"阵雨","conditionIdDay":"3","conditionIdNight":"33","conditionNight":"阵雨","moonphase":"WaxingCrescent","moonrise":"2016-09-08 11:59:00","moonset":"2016-09-08 22:27:00","predictDate":"2016-09-08","sunrise":"2016-09-08 05:49:00","sunset":"2016-09-08 18:34:00","tempDay":"31","tempNight":"17","updatetime":"2016-09-01 22:07:06","windDirDay":"东南风","windDirNight":"北风","windLevelDay":"1","windLevelNight":"1","windSpeedDay":"1.0","windSpeedNight":"1.0"},{"conditionDay":"局部阵雨","conditionIdDay":"3","conditionIdNight":"30","conditionNight":"晴","moonphase":"First","moonrise":"2016-09-09 12:53:00","moonset":"2016-09-09 23:09:00","predictDate":"2016-09-09","sunrise":"2016-09-09 05:50:00","sunset":"2016-09-09 18:33:00","tempDay":"31","tempNight":"18","updatetime":"2016-09-01 22:07:06","windDirDay":"东风","windDirNight":"南风","windLevelDay":"1","windLevelNight":"2","windSpeedDay":"1.0","windSpeedNight":"3.0"},{"conditionDay":"雷阵雨","conditionIdDay":"4","conditionIdNight":"33","conditionNight":"阵雨","moonphase":"WaxingGibbous","moonrise":"2016-09-10 13:45:00","moonset":"2016-09-10 23:55:00","predictDate":"2016-09-10","sunrise":"2016-09-10 05:51:00","sunset":"2016-09-10 18:31:00","tempDay":"31","tempNight":"18","updatetime":"2016-09-01 22:07:06","windDirDay":"东北风","windDirNight":"东风","windLevelDay":"1","windLevelNight":"2","windSpeedDay":"1.0","windSpeedNight":"3.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"多云","moonphase":"WaxingGibbous","moonrise":"2016-09-11 14:35:00","moonset":"2016-09-12 00:46:00","predictDate":"2016-09-11","sunrise":"2016-09-11 05:52:00","sunset":"2016-09-11 18:29:00","tempDay":"31","tempNight":"20","updatetime":"2016-09-01 22:07:06","windDirDay":"西南风","windDirNight":"北风","windLevelDay":"2","windLevelNight":"1","windSpeedDay":"3.0","windSpeedNight":"1.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"多云","moonphase":"WaxingGibbous","moonrise":"2016-09-12 15:24:00","moonset":"2016-09-13 01:43:00","predictDate":"2016-09-12","sunrise":"2016-09-12 05:53:00","sunset":"2016-09-12 18:28:00","tempDay":"31","tempNight":"20","updatetime":"2016-09-01 22:07:06","windDirDay":"南风","windDirNight":"西南风","windLevelDay":"1","windLevelNight":"1","windSpeedDay":"1.0","windSpeedNight":"1.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"少云","moonphase":"WaxingGibbous","moonrise":"2016-09-13 16:08:00","moonset":"2016-09-14 02:44:00","predictDate":"2016-09-13","sunrise":"2016-09-13 05:54:00","sunset":"2016-09-13 18:26:00","tempDay":"31","tempNight":"20","updatetime":"2016-09-01 22:07:06","windDirDay":"东北风","windDirNight":"西北风","windLevelDay":"1","windLevelNight":"2","windSpeedDay":"1.0","windSpeedNight":"3.0"},{"conditionDay":"阵雨","conditionIdDay":"3","conditionIdNight":"33","conditionNight":"阵雨","moonphase":"WaxingGibbous","moonrise":"2016-09-14 16:50:00","moonset":"2016-09-15 03:50:00","predictDate":"2016-09-14","sunrise":"2016-09-14 05:55:00","sunset":"2016-09-14 18:24:00","tempDay":"31","tempNight":"20","updatetime":"2016-09-01 22:07:06","windDirDay":"南风","windDirNight":"东风","windLevelDay":"2","windLevelNight":"1","windSpeedDay":"3.0","windSpeedNight":"1.0"},{"conditionDay":"晴","conditionIdDay":"0","conditionIdNight":"31","conditionNight":"多云","moonphase":"WaxingGibbous","moonrise":"2016-09-15 17:30:00","moonset":"2016-09-16 04:57:00","predictDate":"2016-09-15","sunrise":"2016-09-15 05:55:00","sunset":"2016-09-15 18:23:00","tempDay":"31","tempNight":"18","updatetime":"2016-09-01 22:07:06","windDirDay":"西风","windDirNight":"西风","windLevelDay":"1","windLevelNight":"2","windSpeedDay":"1.0","windSpeedNight":"3.0"}]
         */

        private AliMojiCityBean city;
        private List<ForecastBean> forecast;

        @Data
        public static class CityBean implements Serializable {

            private static final long serialVersionUID = -3313994666951307993L;

            /**
             * cityId : 284609
             * counname : 中国
             * name : 东城区
             * pname : 北京市
             */

            private int cityId;
            private String counname;
            private String name;
            private String pname;
        }

        @Data
        @ApiModel
        public static class ForecastBean implements Serializable {

            private static final long serialVersionUID = 1649596144315557896L;

            /**
             * conditionDay : 多云
             * conditionIdDay : 1
             * conditionIdNight : 31
             * conditionNight : 多云
             * moonphase : WaningCrescent
             * moonrise : 2016-08-31 04:19:00
             * moonset : 2016-08-31 18:07:00
             * predictDate : 2016-08-31
             * sunrise : 2016-08-31 05:41:00
             * sunset : 2016-08-31 18:47:00
             * tempDay : 34
             * tempNight : 18
             * updatetime : 2016-08-31 23:07:06
             * windDirDay : 北风
             * windDirNight : 西北风
             * windLevelDay : 3
             * windLevelNight : 3
             * windSpeedDay : 5.0
             * windSpeedNight : 5.0
             */
            @ApiModelProperty(value = "白天天气", example = "少云")
            private String conditionDay;

            @ApiModelProperty(value = "白天天气id", example = "2")
            private String conditionIdDay;

            @ApiModelProperty(value = "夜间天气id", example = "1")
            private String conditionIdNight;

            @ApiModelProperty(value = "夜间天气", example = "多云")
            private String conditionNight;

            @ApiModelProperty(value = "月相", example = "WaningGibbous")
            private String moonphase;

            @ApiModelProperty(value = "月出", example = "2020-10-07 20:54:00")
            private String moonrise;

            @ApiModelProperty(value = "月落", example = "2020-10-07 10:22:00")
            private String moonset;

            @ApiModelProperty(value = "预报日期", example = "2020-10-07")
            private String predictDate;

            @ApiModelProperty(value = "日出", example = "2020-10-07 05:54:00")
            private String sunrise;

            @ApiModelProperty(value = "日落", example = "2020-10-07 17:34:00")
            private String sunset;

            @ApiModelProperty(value = "白天温度", example = "14")
            private String tempDay;

            @ApiModelProperty(value = "夜间温度", example = "11")
            private String tempNight;

            @ApiModelProperty(value = "更新时间", example = "2020-10-07 23:06:00")
            private String updatetime;

            @ApiModelProperty(value = "白天风向", example = "东北风")
            private String windDirDay;

            @ApiModelProperty(value = "夜间风向", example = "东风")
            private String windDirNight;

            @ApiModelProperty(value = "白天风级", example = "2")
            private String windLevelDay;

            @ApiModelProperty(value = "夜间风向", example = "1")
            private String windLevelNight;

            @ApiModelProperty(value = "白天风速", example = "0.9")
            private String windSpeedDay;

            @ApiModelProperty(value = "夜间风速", example = "2.2")
            private String windSpeedNight;
        }
    }
}
