package com.shawnliang.weather.common.model.resp.ali;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   阿里墨迹——AQI预报5天.
 * @url /whapi/json/alicityweather/aqiforecast5days
 * {
 *   "code": 0,
 *   "data": {
 *     "aqiForecast": [
 *       {
 *         "date": "2016-08-31",
 *         "publishTime": "2016-08-31 00:00:00",
 *         "value": 39
 *       },
 *       {
 *         "date": "2016-09-01",
 *         "publishTime": "2016-09-01 00:00:00",
 *         "value": 18
 *       },
 *       {
 *         "date": "2016-09-02",
 *         "publishTime": "2016-09-01 21:20:00",
 *         "value": 67
 *       },
 *       {
 *         "date": "2016-09-03",
 *         "publishTime": "2016-09-01 21:20:00",
 *         "value": 65
 *       },
 *       {
 *         "date": "2016-09-04",
 *         "publishTime": "2016-09-01 21:20:00",
 *         "value": 134
 *       },
 *       {
 *         "date": "2016-09-05",
 *         "publishTime": "2016-09-01 21:20:00",
 *         "value": 128
 *       }
 *     ],
 *     "city": {
 *       "cityId": 284609,
 *       "counname": "中国",
 *       "name": "东城区",
 *       "pname": "北京市"
 *     }
 *   },
 *   "msg": "success",
 *   "rc": {
 *     "c": 0,
 *     "p": "success"
 *   }
 * }
 * @author : Phoebe
 * @date : Created in 2020/9/20
 */
@Data
@ToString(callSuper = true)
public class AliMojiAqiForecast5Resp extends AliMojiWeatherBaseResp {

    private static final long serialVersionUID = -1991598762932438888L;

    private DataBean data;

    @Data
    public static class DataBean implements Serializable {

        private static final long serialVersionUID = 3531447502621904769L;

        /**
         * aqiForecast : [{"date":"2016-08-31","publishTime":"2016-08-31 00:00:00","value":39},{"date":"2016-09-01","publishTime":"2016-09-01 00:00:00","value":18},{"date":"2016-09-02","publishTime":"2016-09-01 21:20:00","value":67},{"date":"2016-09-03","publishTime":"2016-09-01 21:20:00","value":65},{"date":"2016-09-04","publishTime":"2016-09-01 21:20:00","value":134},{"date":"2016-09-05","publishTime":"2016-09-01 21:20:00","value":128}]
         * city : {"cityId":284609,"counname":"中国","name":"东城区","pname":"北京市"}
         */

        private AliMojiCityBean city;
        private List<AqiForecastBean> aqiForecast;

        @Data
        public static class AqiForecastBean implements Serializable {

            private static final long serialVersionUID = 7566238662501126799L;

            /**
             * date : 2016-08-31
             * publishTime : 2016-08-31 00:00:00
             * value : 39
             */

            private String date;
            private String publishTime;
            private int value;
        }
    }
}
