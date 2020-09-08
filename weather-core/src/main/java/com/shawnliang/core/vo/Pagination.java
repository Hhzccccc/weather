package com.shawnliang.core.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/8
 */
@Data
public class Pagination<T> implements Serializable {

    private static final long serialVersionUID = -2626851464380985671L;

    /**
     * 记录
     */
    private List<T> records;

    /**
     * 总条数
     */
    private long total;

    /**
     * 页大小
     */
    private long size;

    /**
     * 当前页
     */
    private long current;

    /**
     * 总页数
     */
    private long pages;

    /**
     * 是否有下一页
     */
    private Boolean hasNext;

    public Boolean getHasNext() {
        return this.current < this.pages;
    }
}
