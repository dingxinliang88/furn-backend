package com.juzi.furnbackend.common;


import lombok.Data;

import java.io.Serializable;

/**
 * 分页查询请求
 *
 * @author codejuzi
 * @CreateTime 2023/4/10
 */
@Data
public class PageRequest implements Serializable {

    private static final long serialVersionUID = 3589719209060500022L;

    /**
     * 页数，默认第一页
     */
    private Integer pageNum = 1;

    /**
     * 每页显示数据数量，默认每页5条数据
     */
    private Integer pageSize = 5;
}
