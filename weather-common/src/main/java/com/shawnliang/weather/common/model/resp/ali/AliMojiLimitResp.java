package com.shawnliang.weather.common.model.resp.ali;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * Description :   阿里墨迹——限行.
 * @url /whapi/json/alicityweather/limit
 * @author : Phoebe
 * @date : Created in 2020/9/20
 */
@Data
public class AliMojiLimitResp extends AliMojiWeatherBaseResp {

    private static final long serialVersionUID = -8597305549424630882L;
    /**
     * data : {"city":{"cityId":284609,"counname":"中国","name":"东城区","pname":"北京市"},"limit":[{"date":"2016-08-31","prompt":"38"},{"date":"2016-09-01","prompt":"49"},{"date":"2016-09-02","prompt":"50"},{"date":"2016-09-03","prompt":"W"},{"date":"2016-09-04","prompt":"W"},{"date":"2016-09-05","prompt":"16"}]}
     * rc : {"c":0,"p":"success"}
     */
    private DataBean data;

    @Data
    public static class DataBean implements Serializable {

        private static final long serialVersionUID = -6697245048344996772L;

        /**
         * city : {"cityId":284609,"counname":"中国","name":"东城区","pname":"北京市"}
         * limit : [{"date":"2016-08-31","prompt":"38"},{"date":"2016-09-01","prompt":"49"},{"date":"2016-09-02","prompt":"50"},{"date":"2016-09-03","prompt":"W"},{"date":"2016-09-04","prompt":"W"},{"date":"2016-09-05","prompt":"16"}]
         */

        private AliMojiCityBean city;
        private List<LimitBean> limit;

        @Data
        public static class LimitBean implements Serializable {

            private static final long serialVersionUID = 2035071891755731019L;

            /**
             * date : 2016-08-31
             * prompt : 38
             */
            private String date;
            private String prompt;
        }
    }
}
