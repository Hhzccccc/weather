package com.shawnliang.core.utils;

import cn.hutool.crypto.SecureUtil;
import com.shawnliang.weather.common.model.enums.RequestInfoEnum;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/11/2
 */
public class SecurityUtils {

    public static String encryptData(Map<Object, Object> data, String appSecret) {
        Object[] key = data.keySet().toArray();
        Arrays.sort(key);

        StringBuilder bizParams = new StringBuilder();
        for (Object o : key) {
            bizParams.append(o).append("=")
                    .append(data.get(o)).append("&");
        }
        String finalString = bizParams.append(RequestInfoEnum.APP_SECRET.getName()).append("=")
                .append(appSecret).toString();
        String md5Result = SecureUtil.md5(finalString).toUpperCase();
        byte[] sign = sign(md5Result.getBytes(StandardCharsets.UTF_8),
                appSecret.getBytes(StandardCharsets.UTF_8));

        StringBuilder sb = new StringBuilder();
        for (byte item : sign) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));

        }

        return sb.toString().toUpperCase();
    }

    public static void main(String[] args) {
        Map<Object, Object> data = new HashMap<>();

        data.put("lat", "31.150734");
        data.put("lng", "121.124117");

        data.put("randomStr", "abcdeef");
        data.put("timestamp", 1604276045000L);

        String result = SecurityUtils.encryptData(data, "abctdadadada");
        System.out.println(result);
    }

    private static byte[] sign(byte[] data, byte[] key) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(key, "HmacSHA256"));
            return mac.doFinal(data);
        } catch (NoSuchAlgorithmException var3) {
            throw new RuntimeException("Unsupported algorithm: HmacSHA256", var3);
        } catch (InvalidKeyException var4) {
            throw new RuntimeException("Invalid key: " +  var4);
        }
    }

}
