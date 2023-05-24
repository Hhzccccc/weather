package com.shawnliang.weather.dao.weather_market.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author shawnLiang
 * @since 2021-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user_log")
public class UserLogDo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 访问的IP
     */
    private String ip;

    /**
     * 访问设备号
     */
    private String imei;

    /**
     * 用户Id
     */
    private Integer userId;

    /**
     * 访问时间
     */
    private LocalDateTime visitTime;

    /**
     * 访问的日期
     */
    private LocalDate visitDate;

    /**
     * 访问接口名称
     */
    private String requestUrl;

    /**
     * 接口耗时
     */
    private Long useTime;


}
