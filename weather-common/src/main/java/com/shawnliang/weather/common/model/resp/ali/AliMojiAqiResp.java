package com.shawnliang.weather.common.model.resp.ali;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * Description :  阿里墨迹——空气质量响应体 .
 * @url /whapi/json/alicityweather/aqi
 * cityName	城市名称
 * pubtime	发布时间戳
 * value	空气质量指数值
 * co	一氧化碳指数
 * no2	二氧化氮指数
 * o3	臭氧指数
 * pm10	PM10指数
 * pm25	PM2.5指数
 * rank	全国排名
 * coC	一氧化碳浓度
 * no2C	二氧化氮浓度
 * o3C	臭氧浓度
 * pm10C	PM10浓度
 * so2C	二氧化硫浓度
 * pm25C	PM2.5浓度
 * so2	二氧化硫指数
 *
 * @author : Phoebe
 * @date : Created in 2020/9/20
 */
@Data
@ToString(callSuper = true)
public class AliMojiAqiResp extends AliMojiWeatherBaseResp {

    private static final long serialVersionUID = 3087120219427763216L;

    /**
     * msg : success
     * rc : {"p":"success","c":0}
     * code : 0
     * data : {"city":{"counname":"中国","pname":"北京市","name":"东城区","cityId":284609},"aqi":{"no2":"21","cityName":"东城区","o3":"13","pm25":"5","pubtime":"1472688000000","so2":"1","pm10":"43","rank":"222/621","co":"4","value":"43"}}
     */
    private DataEntity data;

    @Data
    public static class DataEntity implements Serializable {

        private static final long serialVersionUID = 9069724865213531083L;
        /**
         * city : {"counname":"中国","pname":"北京市","name":"东城区","cityId":284609}
         * aqi : {"no2":"21","cityName":"东城区","o3":"13","pm25":"5","pubtime":"1472688000000","so2":"1","pm10":"43","rank":"222/621","co":"4","value":"43"}
         */
        private AliMojiCityBean city;
        private AqiEntity aqi;

        @Data
        public static class AqiEntity implements Serializable{

            private static final long serialVersionUID = -4681057651025435721L;
            /**
             * no2 : 21
             * cityName : 东城区
             * o3 : 13
             * pm25 : 5
             * pubtime : 1472688000000
             * so2 : 1
             * pm10 : 43
             * rank : 222/621
             * co : 4
             * value : 43
             */
            private String no2;
            private String cityName;
            private String o3;
            private String pm25;
            private String pubtime;
            private String so2;
            private String pm10;
            private String rank;
            private String co;
            private String value;

        }
    }
}
