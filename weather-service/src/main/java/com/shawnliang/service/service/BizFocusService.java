package com.shawnliang.service.service;

import com.shawnliang.weather.common.model.enums.BizFocusEnum;
import com.shawnliang.weather.dao.weather_market.entity.BizFocusDo;
import org.springframework.scheduling.annotation.Async;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/10/8
 */
public interface BizFocusService {

    /**
     * 异步保存错误日志
     * @param bizFocusDo
     */
    @Async("globalExecutor")
    void saveAsync(BizFocusDo bizFocusDo);

    /**
     * 构建对应的对象
     * @param bizFocusEnum .
     * @param bizData .
     * @return
     */
    BizFocusDo buildEntity(BizFocusEnum bizFocusEnum, String bizData);

    /**
     * 构建对应的对象(带有备注)
     * @param bizFocusEnum .
     * @param bizData .
     * @param remark .
     * @return
     */
    BizFocusDo buildEntityWithRemark(BizFocusEnum bizFocusEnum,
            String bizData, String remark);
}
