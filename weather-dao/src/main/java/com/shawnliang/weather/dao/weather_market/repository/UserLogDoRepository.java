package com.shawnliang.weather.dao.weather_market.repository;

import com.shawnliang.weather.dao.weather_market.entity.UserLogDo;
import com.shawnliang.weather.dao.weather_market.mapper.UserLogMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shawnLiang
 * @since 2021-11-14
 */
@Repository
public class UserLogDoRepository extends ServiceImpl<UserLogMapper, UserLogDo>{

    /**
     *异步保存日志
     */
    @Async("globalExecutor")
    public void saveAsync(UserLogDo userLogDo) {
        this.baseMapper.insert(userLogDo);
    }

}
