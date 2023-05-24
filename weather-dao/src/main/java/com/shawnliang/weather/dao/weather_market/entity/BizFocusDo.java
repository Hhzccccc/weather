package com.shawnliang.weather.dao.weather_market.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 业务关注表
 * </p>
 *
 * @author shawnLiang
 * @since 2020-10-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("biz_focus")
public class BizFocusDo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 业务类型
     */
    private String bizType;

    /**
     * 业务数据(json)
     */
    private String bizData;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
