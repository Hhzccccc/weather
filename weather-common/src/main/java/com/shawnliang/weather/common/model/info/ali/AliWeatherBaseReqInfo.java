package com.shawnliang.weather.common.model.info.ali;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
