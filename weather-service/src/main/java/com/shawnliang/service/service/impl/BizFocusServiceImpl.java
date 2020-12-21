package com.shawnliang.service.service.impl;

import com.shawnliang.service.service.BizFocusService;
import com.shawnliang.weather.common.model.enums.BizFocusEnum;
import com.shawnliang.weather.dao.weather_market.entity.BizFocusDo;
import com.shawnliang.weather.dao.weather_market.repository.BizFocusDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/10/8
 */
@Service
public class BizFocusServiceImpl implements BizFocusService {

    @Autowired
    private BizFocusDoRepository bizFocusDoRepository;

    @Override
    public void saveAsync(BizFocusDo bizFocusDo) {
        bizFocusDoRepository.save(bizFocusDo);
    }

    @Override
    public BizFocusDo buildEntity(BizFocusEnum bizFocusEnum, String bizData) {
        BizFocusDo bizFocusDo = new BizFocusDo();
        bizFocusDo.setBizType(bizFocusEnum.name());
        bizFocusDo.setBizData(bizData);

        return bizFocusDo;
    }

    @Override
    public BizFocusDo buildEntityWithRemark(BizFocusEnum bizFocusEnum, String bizData,
            String remark) {
        BizFocusDo bizFocusDo = buildEntity(bizFocusEnum, bizData);
        bizFocusDo.setRemark(remark);

        return bizFocusDo;
    }
}
