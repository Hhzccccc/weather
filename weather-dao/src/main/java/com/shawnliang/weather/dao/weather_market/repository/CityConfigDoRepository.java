package com.shawnliang.weather.dao.weather_market.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shawnliang.weather.dao.weather_market.entity.CityConfigDo;
import com.shawnliang.weather.dao.weather_market.mapper.CityConfigMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shawnLiang
 * @since 2020-10-04
 */
@Repository
public class CityConfigDoRepository extends ServiceImpl<CityConfigMapper, CityConfigDo>{


    public CityConfigDo getByDistrictName(String districtName) {
        LambdaQueryWrapper<CityConfigDo> wrapper = new QueryWrapper<CityConfigDo>().lambda()
                .likeRight(CityConfigDo::getDistrictName, districtName)
                .last("limit 1");

        return this.baseMapper.selectOne(wrapper);
    }

    public CityConfigDo getByCityName(String cityName) {
        LambdaQueryWrapper<CityConfigDo> wrapper = new QueryWrapper<CityConfigDo>().lambda()
                .eq(CityConfigDo::getCityName, cityName)
                .last("limit 1");

        return this.baseMapper.selectOne(wrapper);
    }

    public CityConfigDo getByProvinceAndCityLikeDistrict(String provinceName, String cityName, String districtName) {
        LambdaQueryWrapper<CityConfigDo> wrapper = new QueryWrapper<CityConfigDo>().lambda()
                .eq(CityConfigDo::getProvinceName, provinceName)
                .eq(CityConfigDo::getCityName, cityName)
                .like(CityConfigDo::getDistrictName, districtName)
                .last("limit 1");

        return this.baseMapper.selectOne(wrapper);
    }

    public CityConfigDo getByProvinceName(String provinceName) {
        LambdaQueryWrapper<CityConfigDo> wrapper = new QueryWrapper<CityConfigDo>().lambda()
                .eq(CityConfigDo::getProvinceName, provinceName)
                .last("limit 1");

        return this.baseMapper.selectOne(wrapper);
    }
}
