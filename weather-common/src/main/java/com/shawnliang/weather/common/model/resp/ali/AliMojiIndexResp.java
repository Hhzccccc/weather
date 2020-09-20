package com.shawnliang.weather.common.model.resp.ali;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   阿里墨迹——生活指数.
 * @url /whapi/json/alicityweather/index
 *
 * @author : Phoebe
 * @date : Created in 2020/9/20
 */
@Data
@ToString(callSuper = true)
public class AliMojiIndexResp extends AliMojiWeatherBaseResp {

    private static final long serialVersionUID = 470495727943725158L;

    /**
     * data : {"city":{"cityId":284609,"counname":"中国","name":"东城区","pname":"北京市"},"liveIndex":{"2016-09-01":[{"day":"2016-09-01","desc":"建议用露质面霜打底，水质无油粉底霜，透明粉饼，粉质胭脂。","name":"化妆指数","status":"控油"},{"day":"2016-09-01","desc":"感冒容易发生，少去人群密集的场所有利于降低感冒的几率。","name":"感冒指数","status":"易发"},{"day":"2016-09-01","desc":"洗车后，可保持2天车辆清洁，比较适宜洗车。","name":"洗车指数","status":"较适宜"},{"day":"2016-09-01","desc":"易感人群应适当减少室外活动。","name":"空气污染扩散指数","status":"中"},{"day":"2016-09-01","desc":"天气较热，衣物精干简洁，室内酌情添加空调衫。","name":"穿衣指数","status":"热"},{"day":"2016-09-01","desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。","name":"紫外线指数","status":"弱"},{"day":"2016-09-01","desc":"天气较好，且紫外线辐射不强，适宜户外运动。","name":"运动指数","status":"适宜"},{"day":"2016-09-01","desc":"气压小幅波动，可能会影响鱼儿的进食。","name":"钓鱼指数","status":"较适宜"}]}}
     * rc : {"c":0,"p":"success"}
     */

    private DataBean data;

    @Data
    public static class DataBean implements Serializable {

        private static final long serialVersionUID = -8066726998969207925L;

        /**
         * city : {"cityId":284609,"counname":"中国","name":"东城区","pname":"北京市"}
         * liveIndex : {"2016-09-01":[{"day":"2016-09-01","desc":"建议用露质面霜打底，水质无油粉底霜，透明粉饼，粉质胭脂。","name":"化妆指数","status":"控油"},{"day":"2016-09-01","desc":"感冒容易发生，少去人群密集的场所有利于降低感冒的几率。","name":"感冒指数","status":"易发"},{"day":"2016-09-01","desc":"洗车后，可保持2天车辆清洁，比较适宜洗车。","name":"洗车指数","status":"较适宜"},{"day":"2016-09-01","desc":"易感人群应适当减少室外活动。","name":"空气污染扩散指数","status":"中"},{"day":"2016-09-01","desc":"天气较热，衣物精干简洁，室内酌情添加空调衫。","name":"穿衣指数","status":"热"},{"day":"2016-09-01","desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。","name":"紫外线指数","status":"弱"},{"day":"2016-09-01","desc":"天气较好，且紫外线辐射不强，适宜户外运动。","name":"运动指数","status":"适宜"},{"day":"2016-09-01","desc":"气压小幅波动，可能会影响鱼儿的进食。","name":"钓鱼指数","status":"较适宜"}]}
         */

        private AliMojiCityBean city;
        private List<LiveIndexBean> liveIndex;

        @Data
        public static class LiveIndexBean implements Serializable{

            private static final long serialVersionUID = 255851959312057034L;

            /**
             * day : 2016-09-01
             * desc : 建议用露质面霜打底，水质无油粉底霜，透明粉饼，粉质胭脂。
             * name : 化妆指数
             * status : 控油
             */
            private String day;
            private String desc;
            private String name;
            private String status;
        }
    }
}
