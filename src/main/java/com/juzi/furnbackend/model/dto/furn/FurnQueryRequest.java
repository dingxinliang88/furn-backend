package com.juzi.furnbackend.model.dto.furn;

import com.juzi.furnbackend.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 家具搜索请求体
 *
 * @author codejuzi
 * @CreateTime 2023/4/10
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FurnQueryRequest extends PageRequest implements Serializable {

    private static final long serialVersionUID = -1184752765272871088L;

    /**
     * 搜索关键词
     */
    private String searchText;
}
