package com.juzi.furnbackend.model.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;

/**
 * furn 实体类
 *
 * @author codejuzi
 * @TableName tb_furn
 */
@TableName(value = "tb_furn")
@Data
public class Furn implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 家居名
     */
    @NotEmpty(message = "请输入家具名")
    private String name;

    /**
     * 厂商
     */
    @NotEmpty(message = "请输入厂商名")
    private String maker;

    /**
     * 价格
     */
    @NotEmpty(message = "请输入价格")
    @Range(min = 0, message = "价格不能小于0")
    private BigDecimal price;

    /**
     * 销量
     */
    @NotEmpty(message = "请输入销量")
    @Range(min = 0, message = "销量不能小于0")
    private Integer sales;

    /**
     * 库存
     */
    @NotEmpty(message = "请输入库存")
    @Range(min = 0, message = "库存不能小于0")
    private Integer stock;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 是否删除 0 - 否， 1 - 是
     */
    @TableLogic
    @TableField("is_delete")
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}