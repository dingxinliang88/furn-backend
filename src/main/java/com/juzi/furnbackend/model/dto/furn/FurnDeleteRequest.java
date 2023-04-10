package com.juzi.furnbackend.model.dto.furn;

import lombok.Data;

import java.io.Serializable;

/**
 * 家具删除请求体
 *
 * @author codejuzi
 * @CreateTime 2023/4/10
 */
@Data
public class FurnDeleteRequest implements Serializable {

    private static final long serialVersionUID = 7944955402879964177L;

    /**
     * id
     */
    private Integer id;
}
