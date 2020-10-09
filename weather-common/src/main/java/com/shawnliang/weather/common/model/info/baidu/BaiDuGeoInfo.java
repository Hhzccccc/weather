package com.shawnliang.weather.common.model.info.baidu;

import java.io.Serializable;
import lombok.Data;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/10/4
 */
@Data
public class BaiDuGeoInfo implements Serializable {

    private static final long serialVersionUID = -5777538692255251926L;

    private String formatted_address;
    private location location;
    private addressComponent addressComponent;

    @Data
    public static class location implements Serializable {

        private static final long serialVersionUID = -5516556296484273074L;

        private String lng;
        private String lat;
    }

    @Data
    public static class addressComponent implements Serializable {

        private static final long serialVersionUID = -8212461545722671236L;

        private String city_level;
        private String country;
        private String town;
        private String distance;
        private String city; //xx市
        private String adcode;
        private String country_code_iso;
        private String country_code_iso2;
        private String country_code;
        private String town_code;
        private String province; //xx省
        private String street; //xx路
        private String district; //xx县
        private String street_number; //xx号
        private String direction;
    }
}

