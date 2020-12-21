package com.shawnliang.weather.common.model.resp.ali;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.ToString;

/**
 * Description :   阿里墨迹——天气预警.
 * @url /whapi/json/alicityweather/alert
 *
 * {
 *   "code": 0,
 *   "data": {
 *     "alert": [
 *       {
 *         "content": "广州市气象局于09月01日17时28分发布雷雨大风蓝色预警信号，请注意防御。",
 *         "infoid": 70,
 *         "level": "蓝色",
 *         "name": "雷雨大风",
 *         "pub_time": "2016-09-01 17:46:06",
 *         "title": "广东省广州市气象台发布蓝色雷雨大风预警",
 *         "type": "雷雨大风蓝色"
 *       }
 *     ],
 *     "city": {
 *       "cityId": 285119,
 *       "counname": "中国",
 *       "name": "越秀区",
 *       "pname": "广东省"
 *     }
 *   },
 *   "msg": "success",
 *   "rc": {
 *     "c": 0,
 *     "p": "success"
 *   }
 * }
 *
 * @author : Phoebe
 * @date : Created in 2020/9/20
 */
@Data
@ToString(callSuper = true)
public class AliMojiAlertResp extends AliMojiWeatherBaseResp {

    private static final long serialVersionUID = -1747254760771842754L;


    /**
     * data : {"alert":[{"content":"广州市气象局于09月01日17时28分发布雷雨大风蓝色预警信号，请注意防御。","infoid":70,"level":"蓝色","name":"雷雨大风","pub_time":"2016-09-01 17:46:06","title":"广东省广州市气象台发布蓝色雷雨大风预警","type":"雷雨大风蓝色"}],"city":{"cityId":285119,"counname":"中国","name":"越秀区","pname":"广东省"}}
     * rc : {"c":0,"p":"success"}
     */

    private DataBean data;

    @Data
    public static class DataBean implements Serializable {

        private static final long serialVersionUID = 4805052504071959414L;

        /**
         * alert : [{"content":"广州市气象局于09月01日17时28分发布雷雨大风蓝色预警信号，请注意防御。","infoid":70,"level":"蓝色","name":"雷雨大风","pub_time":"2016-09-01 17:46:06","title":"广东省广州市气象台发布蓝色雷雨大风预警","type":"雷雨大风蓝色"}]
         * city : {"cityId":285119,"counname":"中国","name":"越秀区","pname":"广东省"}
         */

        private AliMojiCityBean city;
        private List<AlertBean> alert;

        public static class AlertBean {
            /**
             * content : 广州市气象局于09月01日17时28分发布雷雨大风蓝色预警信号，请注意防御。
             * infoid : 70
             * level : 蓝色
             * name : 雷雨大风
             * pub_time : 2016-09-01 17:46:06
             * title : 广东省广州市气象台发布蓝色雷雨大风预警
             * type : 雷雨大风蓝色
             */

            private String content;
            private int infoid;
            private String level;
            private String name;
            private String pub_time;
            private String title;
            private String type;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getInfoid() {
                return infoid;
            }

            public void setInfoid(int infoid) {
                this.infoid = infoid;
            }

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPub_time() {
                return pub_time;
            }

            public void setPub_time(String pub_time) {
                this.pub_time = pub_time;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}
