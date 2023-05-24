package com.shawnliang.weather.common.model.info.ali;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

/**
 * Description :  调用阿里墨迹天气的api对象 .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/20
 */
@Data
@Builder
public class AliWeatherApiInfo implements Serializable {

    private static final long serialVersionUID = -8472260012794571173L;

    /**
     * 接口Url
     */
    private String apiUrl;

    /**
     * 接口token
     */
    private String token;
}
