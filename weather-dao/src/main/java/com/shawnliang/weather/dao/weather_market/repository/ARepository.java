package com.shawnliang.weather.dao.weather_market.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shawnliang.weather.dao.weather_market.entity.A;
import com.shawnliang.weather.dao.weather_market.mapper.AMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * a 服务实现类
 * </p>
 *
 * @author shawnLiang
 * @since 2020-09-13
 */
@Repository
public class ARepository extends ServiceImpl<AMapper, A>{

    public A listA(String corpNo) {
        LambdaQueryWrapper<A> queryWrapper = new QueryWrapper<A>().lambda();
        queryWrapper.eq(A::getAge, 11);
        return this.baseMapper.selectOne(queryWrapper);
    }

    /**
     * 分页查所有
     * @return
     */
    public IPage<A> pageA() {
        LambdaQueryWrapper<A> queryWrapper = new QueryWrapper<A>().lambda();
        return this.baseMapper.selectPage(new Page<>(1, 100), queryWrapper);
    }
}
