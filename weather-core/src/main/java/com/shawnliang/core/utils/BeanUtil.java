package com.shawnliang.core.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/20
 */
public class BeanUtil {

    public static <T> T copyPropertiesJson(Object source, Class<T> target) {
        if (source == null) {
            return null;
        } else {
            String sourceStr = JSONObject.toJSONString(source);
            return JSONObject.parseObject(sourceStr, target);
        }
    }

    public static <T> T copyPropertiesJson(Object source, Class<T> target, String[] ignoreProperties) {
        if (source == null) {
            return null;
        } else {
            SimplePropertyPreFilter filter = new SimplePropertyPreFilter(target, ignoreProperties);
            String sourceStr = JSONObject.toJSONString(source, filter, new SerializerFeature[0]);
            return JSONObject.parseObject(sourceStr, target);
        }
    }

    public static <T> List<T> copyPropertiesJson(List<?> source, Class<T> target) {
        return source == null ? null : (List)source.stream().map((item) -> {
            return copyPropertiesJson(item, target);
        }).collect(Collectors.toList());
    }

    public static <T> List<T> copyPropertiesJson(List<?> source, Class<T> target, String[] ignoreProperties) {
        return source == null ? null : (List)source.stream().map((item) -> {
            return copyPropertiesJson(item, target, ignoreProperties);
        }).collect(Collectors.toList());
    }

}
