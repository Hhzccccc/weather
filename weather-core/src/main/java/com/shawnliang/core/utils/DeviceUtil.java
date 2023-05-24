package com.shawnliang.core.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/11/14
 */
public class DeviceUtil {

    /**
     * 获取请求设备信息
     * @author gaodongyang
     * @date 2020/8/11 14:19
     * @param request 请求
     * @return String 设备信息 pc端还是手机端
     **/
    public static String getDeviceInfo(HttpServletRequest request) {
        ///定义正则
        String pattern = "^Mozilla/\\d\\.\\d\\s+\\(+.+?\\)";
        String pattern2 = "\\(+.+?\\)";
        ///将给定的正则表达式编译到模式中
        Pattern r = Pattern.compile(pattern);
        Pattern r2 = Pattern.compile(pattern2);

        String userAgent = request.getHeader("User-Agent");
        ///创建匹配给定输入与此模式的匹配器
        Matcher m = r.matcher(userAgent);
        String result = null;
        if (m.find()) {
            result = m.group(0);
        }
        if(result == null){
            return null;
        }
        Matcher m2 = r2.matcher(result);
        if (m2.find()) {
            result = m2.group(0);
        }
        result = result.replace("(", "");
        result = result.replace(")", "");

        if (StringUtils.isBlank(result)) {
            return null;
        }
        result = result.replace(" U;", "");
        result = result.replace(" zh-cn;", "");

        return result;
    }


}
