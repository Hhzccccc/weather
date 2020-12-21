package com.shawnliang.web.util;

import com.shawnliang.service.util.BaiDuMapUtil;
import com.shawnliang.weather.common.model.info.baidu.BaiDuGeoInfo;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/10/4
 */
public class BaiduMapUtilTest  {

    public static void main(String[] args) {
        BaiDuGeoInfo locationByGeo = BaiDuMapUtil.getLocationByGeo( "31.2646", "121.505133");
        System.out.println(locationByGeo);
    }

}
