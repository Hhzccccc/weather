package com.shawnliang.weather.common.model.info.ali;

import cn.hutool.core.date.DateUtil;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AliWeatherBaseReqInfo {

    private Integer cityCode;

    /**
     * redis的缓存key
     */
    @Builder.Default
    private String redisKey = StringUtils.join(DateUtil.format(LocalDateTime.now(), "yyyyMMdd"), ":");
}
