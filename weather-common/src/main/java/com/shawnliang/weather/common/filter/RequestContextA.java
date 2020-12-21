package com.shawnliang.weather.common.filter;

import java.util.HashMap;
import java.util.Map;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/11/21
 */
public class RequestContextA {

    private static final ThreadLocal<RequestContextA> THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 上下文内容
     */
    private Map<String, String> contextDetail = new HashMap<>();

    public static RequestContextA getContext() {
        RequestContextA RequestContextA = THREAD_LOCAL.get();
        if (RequestContextA == null) {
            RequestContextA = new RequestContextA();
            THREAD_LOCAL.set(RequestContextA);
        }
        return RequestContextA;
    }



    /**
     * 关闭上下文
     */
    public static void clear() {
        THREAD_LOCAL.remove();
    }

    /**
     * 增加上下文内容
     */
    public void addContextDetail(String key, String value) {
        contextDetail.put(key, value);
    }

    /**
     * 删除上下问内容
     */
    public void removeContextDetail(String key) {
        contextDetail.remove(key);
    }

    /**
     * 获取上下文内容
     */
    public String getContextDetail(String key) {
        return contextDetail.get(key);
    }

    public Map<String, String> getContextDetails() {
        return contextDetail;
    }


}
