package com.shawnliang.weather.common.model.resp.ali;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.ToString;

/**
 * Description :  阿里墨迹——天气预报24小时 .
 * @url /whapi/json/alicityweather/forecast24hours
 * @author : Phoebe
 * @date : Created in 2020/9/20
 */
@Data
@ToString(callSuper = true)
@ApiModel
public class AliMojiForecast24HoursResp extends AliMojiWeatherBaseResp {

    private static final long serialVersionUID = 6682848519327330744L;


    /**
     * data : {"city":{"cityId":284609,"counname":"中国","name":"东城区","pname":"北京市"},"hourly":[{"condition":"阴","date":"2016-09-01","hour":"20","humidity":"51","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"21","temp":"23","uvi":"0","windDir":"N","windSpeed":"12"},{"condition":"阴","date":"2016-09-01","hour":"21","humidity":"56","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"21","temp":"22","uvi":"0","windDir":"NNW","windSpeed":"11"},{"condition":"阴","date":"2016-09-01","hour":"22","humidity":"60","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"20","temp":"22","uvi":"0","windDir":"NNW","windSpeed":"11"},{"condition":"阴","date":"2016-09-01","hour":"23","humidity":"62","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"19","temp":"21","uvi":"0","windDir":"NW","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"0","humidity":"62","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"19","temp":"21","uvi":"0","windDir":"NW","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"1","humidity":"63","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"19","temp":"21","uvi":"0","windDir":"NW","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"2","humidity":"66","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"19","temp":"20","uvi":"0","windDir":"NW","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"3","humidity":"68","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"18","temp":"19","uvi":"0","windDir":"NNW","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"4","humidity":"68","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"18","temp":"19","uvi":"0","windDir":"NNW","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"5","humidity":"72","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"18","temp":"19","uvi":"0","windDir":"NNW","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"6","humidity":"71","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"19","temp":"20","uvi":"0","windDir":"NNW","windSpeed":"9"},{"condition":"少云","date":"2016-09-02","hour":"7","humidity":"65","iconDay":"1","iconNight":"31","pressure":"0","realFeel":"20","temp":"21","uvi":"1","windDir":"NNW","windSpeed":"9"},{"condition":"少云","date":"2016-09-02","hour":"8","humidity":"57","iconDay":"1","iconNight":"31","pressure":"0","realFeel":"23","temp":"22","uvi":"2","windDir":"NNW","windSpeed":"11"},{"condition":"少云","date":"2016-09-02","hour":"9","humidity":"49","iconDay":"1","iconNight":"31","pressure":"0","realFeel":"25","temp":"24","uvi":"3","windDir":"NNW","windSpeed":"11"},{"condition":"少云","date":"2016-09-02","hour":"10","humidity":"44","iconDay":"1","iconNight":"31","pressure":"0","realFeel":"27","temp":"25","uvi":"4","windDir":"NNW","windSpeed":"11"},{"condition":"少云","date":"2016-09-02","hour":"11","humidity":"42","iconDay":"1","iconNight":"31","pressure":"0","realFeel":"27","temp":"26","uvi":"4","windDir":"NNW","windSpeed":"11"},{"condition":"少云","date":"2016-09-02","hour":"12","humidity":"39","iconDay":"1","iconNight":"31","pressure":"0","realFeel":"28","temp":"27","uvi":"4","windDir":"N","windSpeed":"11"},{"condition":"阴","date":"2016-09-02","hour":"13","humidity":"38","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"28","temp":"27","uvi":"3","windDir":"N","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"14","humidity":"37","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"28","temp":"28","uvi":"2","windDir":"N","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"15","humidity":"37","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"28","temp":"28","uvi":"2","windDir":"N","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"16","humidity":"36","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"27","temp":"28","uvi":"1","windDir":"N","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"17","humidity":"39","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"26","temp":"27","uvi":"0","windDir":"SSW","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"18","humidity":"45","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"25","temp":"26","uvi":"0","windDir":"S","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"19","humidity":"53","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"24","temp":"25","uvi":"0","windDir":"S","windSpeed":"9"},{"condition":"少云","date":"2016-09-02","hour":"20","humidity":"62","iconDay":"1","iconNight":"31","pressure":"0","realFeel":"23","temp":"24","uvi":"0","windDir":"S","windSpeed":"9"},{"condition":"少云","date":"2016-09-02","hour":"21","humidity":"62","iconDay":"1","iconNight":"31","pressure":"0","realFeel":"23","temp":"23","uvi":"0","windDir":"S","windSpeed":"6"}]}
     * rc : {"c":0,"p":"success"}
     */

    private DataBean data;

    @Data
    @ApiModel
    public static class DataBean implements Serializable {

        private static final long serialVersionUID = 1259769497750045114L;

        /**
         * city : {"cityId":284609,"counname":"中国","name":"东城区","pname":"北京市"}
         * hourly : [{"condition":"阴","date":"2016-09-01","hour":"20","humidity":"51","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"21","temp":"23","uvi":"0","windDir":"N","windSpeed":"12"},{"condition":"阴","date":"2016-09-01","hour":"21","humidity":"56","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"21","temp":"22","uvi":"0","windDir":"NNW","windSpeed":"11"},{"condition":"阴","date":"2016-09-01","hour":"22","humidity":"60","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"20","temp":"22","uvi":"0","windDir":"NNW","windSpeed":"11"},{"condition":"阴","date":"2016-09-01","hour":"23","humidity":"62","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"19","temp":"21","uvi":"0","windDir":"NW","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"0","humidity":"62","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"19","temp":"21","uvi":"0","windDir":"NW","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"1","humidity":"63","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"19","temp":"21","uvi":"0","windDir":"NW","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"2","humidity":"66","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"19","temp":"20","uvi":"0","windDir":"NW","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"3","humidity":"68","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"18","temp":"19","uvi":"0","windDir":"NNW","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"4","humidity":"68","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"18","temp":"19","uvi":"0","windDir":"NNW","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"5","humidity":"72","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"18","temp":"19","uvi":"0","windDir":"NNW","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"6","humidity":"71","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"19","temp":"20","uvi":"0","windDir":"NNW","windSpeed":"9"},{"condition":"少云","date":"2016-09-02","hour":"7","humidity":"65","iconDay":"1","iconNight":"31","pressure":"0","realFeel":"20","temp":"21","uvi":"1","windDir":"NNW","windSpeed":"9"},{"condition":"少云","date":"2016-09-02","hour":"8","humidity":"57","iconDay":"1","iconNight":"31","pressure":"0","realFeel":"23","temp":"22","uvi":"2","windDir":"NNW","windSpeed":"11"},{"condition":"少云","date":"2016-09-02","hour":"9","humidity":"49","iconDay":"1","iconNight":"31","pressure":"0","realFeel":"25","temp":"24","uvi":"3","windDir":"NNW","windSpeed":"11"},{"condition":"少云","date":"2016-09-02","hour":"10","humidity":"44","iconDay":"1","iconNight":"31","pressure":"0","realFeel":"27","temp":"25","uvi":"4","windDir":"NNW","windSpeed":"11"},{"condition":"少云","date":"2016-09-02","hour":"11","humidity":"42","iconDay":"1","iconNight":"31","pressure":"0","realFeel":"27","temp":"26","uvi":"4","windDir":"NNW","windSpeed":"11"},{"condition":"少云","date":"2016-09-02","hour":"12","humidity":"39","iconDay":"1","iconNight":"31","pressure":"0","realFeel":"28","temp":"27","uvi":"4","windDir":"N","windSpeed":"11"},{"condition":"阴","date":"2016-09-02","hour":"13","humidity":"38","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"28","temp":"27","uvi":"3","windDir":"N","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"14","humidity":"37","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"28","temp":"28","uvi":"2","windDir":"N","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"15","humidity":"37","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"28","temp":"28","uvi":"2","windDir":"N","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"16","humidity":"36","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"27","temp":"28","uvi":"1","windDir":"N","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"17","humidity":"39","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"26","temp":"27","uvi":"0","windDir":"SSW","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"18","humidity":"45","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"25","temp":"26","uvi":"0","windDir":"S","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"19","humidity":"53","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"24","temp":"25","uvi":"0","windDir":"S","windSpeed":"9"},{"condition":"少云","date":"2016-09-02","hour":"20","humidity":"62","iconDay":"1","iconNight":"31","pressure":"0","realFeel":"23","temp":"24","uvi":"0","windDir":"S","windSpeed":"9"},{"condition":"少云","date":"2016-09-02","hour":"21","humidity":"62","iconDay":"1","iconNight":"31","pressure":"0","realFeel":"23","temp":"23","uvi":"0","windDir":"S","windSpeed":"6"}]
         */

        private AliMojiCityBean city;
        private List<HourlyBean> hourly;

        @Data
        @ApiModel
        public static class HourlyBean implements Serializable {

            private static final long serialVersionUID = 6548804432816636400L;

            /**
             {
             "condition": "多云",
             "date": "2020-10-08",
             "hour": "21",
             "humidity": "70",
             "iconDay": "1",
             "iconNight": "31",
             "pressure": "1022",
             "realFeel": "20",
             "temp": "19",
             "uvi": "1",
             "windDir": "N",
             "windSpeed": "22.32"
             },
             */
            @ApiModelProperty(value = "天气状况", example = "晴")
            private String condition;

            @ApiModelProperty(value = "预报日期", example = "2020-10-08")
            private String date;

            @ApiModelProperty(value = "小时", example = "20")
            private String hour;

            @ApiModelProperty(value = "湿度", example = "70")
            private String humidity;

            @ApiModelProperty(value = "白天icon", example = "20")
            private String iconDay;

            @ApiModelProperty(value = "夜间icon", example = "20")
            private String iconNight;

            @ApiModelProperty(value = "气压", example = "1022")
            private String pressure;

            @ApiModelProperty(value = "体感温度", example = "20")
            private String realFeel;

            @ApiModelProperty(value = "实时温度", example = "25")
            private String temp;

            @ApiModelProperty(value = "紫外线强度", example = "1")
            private String uvi;

            @ApiModelProperty(value = "风向", example = "NNE")
            private String windDir;

            @ApiModelProperty(value = "风速", example = "11.88")
            private String windSpeed;
        }
    }
}
