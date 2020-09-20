package com.shawnliang.core.utils;

import com.alibaba.fastjson.JSONObject;
import com.shawnliang.weather.common.exception.BusinessException;
import com.shawnliang.weather.common.exception.CommonError;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ConnectionPool;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/18
 */
@Slf4j
public class HttpUtil {

    /**
     * 新建一个Http请求连接
     * 1. 设置连接超时时间为 2s
     * 2. 设置读取超时时间为 4s
     * 3. 设置写入超时时间为 4s
     */
    private static OkHttpClient httpClient;

    /**
     * 静态初始化
     */
    static {
        initHttpClient();
    }

    /**
     * HttpClient初始化
     */
    private static void initHttpClient() {
        httpClient = new OkHttpClient.Builder().connectTimeout(2, TimeUnit.SECONDS)
                .writeTimeout(4, TimeUnit.SECONDS)
                .readTimeout(4, TimeUnit.SECONDS)
                .connectionPool(new ConnectionPool(10, 30L, TimeUnit.SECONDS))
                .build();
    }

    /**
     * OkHttp post请求
     *
     * @param url  url链接
     * @param map  请求键值对
     *
     * @return .
     */
    public static JSONObject postRequest(String url, Map<String, Object> map){
        return postRequest(url, null, map);
    }

    /**
     * OkHttp post请求
     *
     * @param url  url链接
     * @param o    数据对象
     *
     * @return .
     */
    public static JSONObject postRequest(String url, Object o){
        return postRequest(url, MediaType.parse("application/json; charset=utf-8"), JSONObject.toJSONString(o));
    }

    /**
     * OkHttp post请求
     *
     * @param url    url链接
     * @param string json格式数据
     *
     * @return .
     */
    public static JSONObject postRequest(String url, String string){
        return postRequest(url, MediaType.parse("application/json; charset=utf-8"), string);
    }

    /**
     * OkHttp post请求
     *
     * @param url  url链接
     * @param headersMap 请求头键值对
     * @param paramsMap  请求内容键值对
     *
     * @return .
     */
    public static JSONObject postRequest(String url, Map<String, Object> headersMap, Map<String, Object> paramsMap){
        log.info("postRequest请求Header参数：map: {}", headersMap);
        log.info("postRequest请求Param参数：map: {}", paramsMap);

        // 设置 Header 信息
        Request.Builder requestBuilder = new Request.Builder();
        if (headersMap != null) {
            for (Map.Entry<String, Object> entry : headersMap.entrySet()) {
                if (entry.getValue() == null) {
                    continue;
                }
                requestBuilder.addHeader(entry.getKey(), entry.getValue().toString());
            }
        }

        // 设置 Param 信息
        FormBody.Builder builder = new FormBody.Builder();
        if (paramsMap != null) {
            for (Map.Entry<String, Object> entry : paramsMap.entrySet()) {
                if (entry.getValue() == null) {
                    continue;
                }
                builder.add(entry.getKey(), entry.getValue().toString());
            }
        }
        RequestBody formBody = builder.build();

        Request request  = requestBuilder
                .url(url)
                .post(formBody)
                .build();
        return doRequest(request);
    }

    /**
     * OkHttp post请求
     *
     * @param url        url链接
     * @param headersMap 请求头键值对
     * @param jsonObject 请求内容键值对
     *
     * @return .
     */
    public static JSONObject postRequest(String url, Map<String, Object> headersMap, String jsonObject){
        return postRequest(url, headersMap, MediaType.parse("application/json; charset=utf-8"), jsonObject);
    }

    /**
     * OkHttp post请求
     *
     * @param url        url链接
     * @param headersMap 请求头键值对
     * @param mediaType  媒体格式
     * @param jsonObject 请求内容键值对
     *
     * @return .
     */
    public static JSONObject postRequest(String url, Map<String, Object> headersMap, MediaType mediaType, String jsonObject){
        log.info("postRequest请求Header参数：map: {}", headersMap);
        log.info("postRequest请求Param参数：string: {}", jsonObject);

        // 设置 Header 信息
        Request.Builder requestBuilder = new Request.Builder();
        if (headersMap != null) {
            for (Map.Entry<String, Object> entry : headersMap.entrySet()) {
                if (entry.getValue() == null) {
                    continue;
                }
                requestBuilder.addHeader(entry.getKey(), entry.getValue().toString());
            }
        }

        RequestBody requestBody = RequestBody.create(mediaType, jsonObject);
        Request request  = requestBuilder
                .url(url)
                .post(requestBody)
                .build();
        return doRequest(request);
    }

    /**
     * OkHttp post请求
     *
     * @param url       url链接
     * @param mediaType 媒体格式
     * @param string    json格式数据
     *
     * @return .
     */
    public static JSONObject postRequest(String url, MediaType mediaType, String string){
        log.info("postRequest请求参数：string: {}", string);

        RequestBody requestBody = RequestBody.create(mediaType, string);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        return doRequest(request);
    }

    /**
     * OkHttp get请求方式
     *
     * @param url url链接
     *
     * @param query 请求query
     *
     * @return .
     */
    public static JSONObject getRequest(String url, String query) {
        //构建请求Url
        HttpUrl.Builder httpUrlBuilder = Objects
                .requireNonNull(HttpUrl.parse(url)).newBuilder().query(query);

        //构建请求对象
        Request request = new Request.Builder()
                .url(httpUrlBuilder.build())
                .get()
                .build();

        return doRequest(request);
    }

    /**
     * OkHttp get请求方式
     *
     * @param url url链接
     *
     * @param o 数据对象
     *
     * @return .
     */
    public static JSONObject getRequest(String url, Object o) {
        //构建请求Url
        HttpUrl.Builder httpUrlBuilder = Objects
                .requireNonNull(HttpUrl.parse(url)).newBuilder();

        try {
            Class<?> c = o.getClass();
            ArrayList<Field> fields = new ArrayList<>();
            while (c != null) {
                fields.addAll(Arrays.asList(c.getDeclaredFields()));
                c = c.getSuperclass();
            }

            for (Field field : fields) {
                field.setAccessible(true);
                String name = field.getName();
                Object value = field.get(o);
                if(value != null && !"serialVersionUID".equalsIgnoreCase(name)) {
                    httpUrlBuilder.addQueryParameter(name, value.toString());
                }
            }
        } catch (IllegalAccessException e) {
            log.error("对象转换url异常：{}", e);
        }

        //构建请求对象
        Request request = new Request.Builder()
                .url(httpUrlBuilder.build())
                .get()
                .build();

        return doRequest(request);
    }

    /**
     * OkHttp get请求方式
     *
     * @param url url链接
     *
     * @param map 数据
     *
     * @return .
     */
    public static JSONObject getRequest(String url, Map<String, Object> map){
        //构建请求Url
        HttpUrl.Builder httpUrlBuilder = Objects
                .requireNonNull(HttpUrl.parse(url)).newBuilder();
        map.forEach(
                (key, value) ->
                        httpUrlBuilder.addQueryParameter(key, value.toString()));
        //构建请求对象
        Request request = new Request.Builder()
                .url(httpUrlBuilder.build())
                .get()
                .build();

        return doRequest(request);
    }

    /**
     * 执行请求
     *
     * @param request 请求体
     *
     * @return Json对象
     */
    public static JSONObject doRequest(Request request) {
        if (httpClient == null) {
            initHttpClient();
        }

        log.info("doRequest请求参数：{}", request);

        // 执行请求
        try {
            Response response = httpClient.newCall(request).execute();
            if (response.body() == null) {
                return null;
            }

            String result = response.body().string();
            log.info("doRequest请求结果jsonObject：{}", result);

            return JSONObject.parseObject(result);
        } catch (IOException e) {
            log.error("Ok http 超时", e);
            throw new BusinessException(CommonError.SYSTEM_ERROR, "OkHTTP服务超时");
        }
    }

    /**
     * 远程调用HuixianResponse 转换
     *
     * @return .
     */
    public static JSONObject convertHuixianResponseResultsToObject(JSONObject jsonObject) {

        if(jsonObject == null) {
            throw new BusinessException(CommonError.SYSTEM_ERROR);
        }

        if (jsonObject.getInteger("errorCode") != 0) {
            throw new BusinessException(CommonError.SYSTEM_ERROR, jsonObject.getString("errorStr"));
        }

        if(StringUtils.isBlank(jsonObject.getString("results"))) {
            return null;
        }

        return jsonObject.getJSONObject("results");
    }


    /**
     * 远程调用HuixianResponse 转换
     *
     * @param target .
     *
     * @param <T> .
     *
     * @return .
     */
    public static <T> T convertHuixianResponseResultsToObject(JSONObject jsonObject, Class<T> target) {

        if(jsonObject == null) {
            throw new BusinessException(CommonError.SYSTEM_ERROR);
        }

        if (jsonObject.getInteger("errorCode") != 0) {
            throw new BusinessException(CommonError.SYSTEM_ERROR, jsonObject.getString("errorStr"));
        }

        if(StringUtils.isBlank(jsonObject.getString("results"))) {
            return null;
        }

        return JSONObject.parseObject(jsonObject.getString("results"), target);
    }

    /**
     * 远程调用HuixianResponse 转换
     *
     * @param target .
     *
     * @param <T> .
     *
     * @return .
     */
    public static <T> List<T> convertResponseResultToList(JSONObject jsonObject, Class<T> target) {

        if(jsonObject == null) {
            throw new BusinessException(CommonError.SYSTEM_ERROR);
        }

        if (jsonObject.getInteger("errorCode") != 0) {
            throw new BusinessException(CommonError.SYSTEM_ERROR, jsonObject.getString("errorStr"));
        }
        if(StringUtils.isBlank(jsonObject.getString("results"))) {
            return null;
        }

        return JSONObject.parseArray(jsonObject.getString("results"), target);
    }
}
