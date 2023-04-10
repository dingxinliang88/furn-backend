package com.juzi.furnbackend.model.dto.furn;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 家居修改请求体
 *
 * @author codejuzi
 * @CreateTime 2023/4/10
 */
@Data
public class FurnUpdateRequest implements Serializable {

    private static final long serialVersionUID = 5407351056204124689L;

    /**
     * id
     */
    private Integer id;

    /**
     * 家居名
     */
    private String name;

    /**
     * 厂商
     */
    private String maker;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 销量
     */
    private Integer sales;

    /**
     * 库存
     */
    private Integer stock;

}

