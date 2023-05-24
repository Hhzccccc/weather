package com.shawnliang.service.util;

import com.alibaba.fastjson.JSONObject;
import com.shawnliang.core.utils.BeanUtil;
import com.shawnliang.core.utils.HttpUtil;
import com.shawnliang.weather.common.model.info.baidu.BaiDuGeoInfo;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * Description : 百度地图工具类  .
 *
 * @author : Phoebe
 * @date : Created in 2020/10/4
 */
@Slf4j
public class BaiDuMapUtil {

    public static final String IP_LOCATION_URL = "https://api.map.baidu.com/location/ip";
    public static final String REVERSE_GEOCODING_URL = "http://api.map.baidu.com/reverse_geocoding/v3/";

    public static final String AK = "97xAn71IpMeTmC8uCgl8CDr25u0GtXtv";

    public static String getLocationByIp(String ip) {
        try {
            Map<String, Object> params = new HashMap<>(4);
            params.put("ak", AK);
            params.put("ip", ip);
            params.put("coor", "bd09ll");
            JSONObject responseBody = HttpUtil.getRequest(IP_LOCATION_URL, params);
            return responseBody.getJSONObject("content").getString("address");
        } catch (Exception e) {
            log.error("百度地图获取IP 异常", e);
            return "未知";
        }
    }


    /**
     * 百度的逆编码API
     * <p>
     *  http://lbsyun.baidu.com/index.php?title=webapi/guide/webservice-geocoding-abroad
     *  参考百度的经纬度文档
     *</p>
     * @param lat 纬度
     * @param lng 经度
     * @return
     */
    public static BaiDuGeoInfo getLocationByGeo(String lat, String lng) {
        try {
            if (StringUtils.isBlank(lat) || StringUtils.isBlank(lng)) {
                return null;
            }

            Map<String, Object> params = new HashMap<>(4);
            params.put("ak", AK);
            params.put("location", StringUtils.join(lat, ",", lng));
            params.put("coordtype", "wgs84ll");
            params.put("output", "json");
            params.put("language", "zh-CN");
            JSONObject responseBody = HttpUtil.getRequest(REVERSE_GEOCODING_URL, params);
            JSONObject result = responseBody.getJSONObject("result");
            return BeanUtil.copyPropertiesJson(result, BaiDuGeoInfo.class);
        } catch (Exception e) {
            log.error("百度ip 转换异常", e);
            return null;
        }
    }
}
