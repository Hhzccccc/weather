package com.shawnliang.core.aop;

import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import com.google.common.hash.Funnel;
import com.shawnliang.core.component.PropertiesComponent;
import com.shawnliang.core.utils.BloomUtils;
import com.shawnliang.core.utils.IpUtil;
import com.shawnliang.core.utils.RedisUtils;
import com.shawnliang.core.utils.SecurityUtils;
import com.shawnliang.weather.common.exception.BusinessException;
import com.shawnliang.weather.common.exception.CommonError;
import com.shawnliang.weather.common.model.enums.RequestInfoEnum;
import java.lang.reflect.Field;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/10/30
 */
@Aspect
@Slf4j
public class SignSecurityInterceptor {

    @Autowired
    private PropertiesComponent propertiesComponent;

    @Autowired
    private RedisUtils redisUtils;


    @Pointcut("@annotation(com.shawnliang.core.annonation.Security)")
    public void securityPointCut() {
    }

    /**
     * 参数安全校验
     */
    @Around("securityPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.
                getRequestAttributes()).getRequest();
        String timestamp = request.getHeader(RequestInfoEnum.TIMESTAMP.getName());
        String encrypt = request.getHeader(RequestInfoEnum.SIGNATURE.getName());
        String randomStr = request.getHeader(RequestInfoEnum.RANDOM_STR.getName());
        if (StringUtils.isBlank(timestamp) || StringUtils.isBlank(randomStr)) {
            log.error("非法IP ：[{}]", IpUtil.getRequestIp(request));
            throw new BusinessException(CommonError.COMMON_BIZ_ERROR, "请求无效！");
        }

        // MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Map<Object, Object> data = new HashMap<>(8);
        data.put(RequestInfoEnum.TIMESTAMP.getName(), timestamp);
        data.put(RequestInfoEnum.RANDOM_STR.getName(), randomStr);

        LocalDateTime localDate = Instant.ofEpochMilli(Long.parseLong(timestamp))
                .atZone(ZoneOffset.ofHours(8)).toLocalDateTime();

        if (localDate.plus(10, ChronoUnit.SECONDS).isBefore(LocalDateTime.now())) {
            throw new BusinessException(CommonError.COMMON_BIZ_ERROR, "请求已过期！");
        }

        if (redisUtils.includeByBloomFilter(createBloomUtils(), RedisUtils.BLOOM_KEY, encrypt)) {
            log.info("请求重复！{}", encrypt);
            throw new BusinessException(CommonError.COMMON_BIZ_ERROR, "请求重复！");
        }

        for (int i = 0; i < joinPoint.getArgs().length; i++) {
            Object arg = joinPoint.getArgs()[i];
            Map<Object, Object> map = getKeyAndValue(arg);
            data.putAll(map);
        }
        if (!StringUtils.equals(SecurityUtils.encryptData(data, propertiesComponent.getAppSecret()), encrypt)) {
            throw new BusinessException(CommonError.COMMON_BIZ_ERROR, "签名验证失败！");
        }

        redisUtils.addByBloomFilter(createBloomUtils(), RedisUtils.BLOOM_KEY, encrypt);
        return joinPoint.proceed();

    }

    private BloomUtils<String> createBloomUtils() {
      return  new BloomUtils<>((Funnel<String>) (from,
                into) -> into.putString(from, Charsets.UTF_8).putString(from, Charsets.UTF_8), 1500000, 0.00001);

    }


    /**
     * 获取单个对象的所有键值对
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> Map<Object, Object> getKeyAndValue(T t) {
        Map<Object, Object> map = Maps.newHashMap();
        Class clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();
        map = Arrays.stream(fields).collect(Collectors.toMap(Field::getName, field -> {
            Object resultObj = null;
            field.setAccessible(true);
            try {
                resultObj = field.get(t);
            } catch (Exception e) {
                log.error("解析对象异常", e);
            }
            return Optional.ofNullable(resultObj).orElse(0);
        }, (k1, k2) -> k2));

        map.remove("serialVersionUID");
        return map;
    }

    }
