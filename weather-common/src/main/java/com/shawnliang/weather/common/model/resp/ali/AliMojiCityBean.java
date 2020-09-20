package com.shawnliang.weather.common.model.resp.ali;

import java.io.Serializable;
import lombok.Data;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/20
 */
@Data
public class AliMojiCityBean implements Serializable {

    private static final long serialVersionUID = 8792705201734041065L;

    /**
     * cityId : 284609
     * counname : 中国
     * name : 东城区
     * pname : 北京市
     */

    private int cityId;
    private String counname;
    private String name;
    private String pname;
}
