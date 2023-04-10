package com.juzi.furnbackend.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.juzi.furnbackend.common.PageRequest;
import com.juzi.furnbackend.model.domain.Furn;
import com.baomidou.mybatisplus.extension.service.IService;
import com.juzi.furnbackend.model.dto.furn.FurnAddRequest;
import com.juzi.furnbackend.model.dto.furn.FurnDeleteRequest;
import com.juzi.furnbackend.model.dto.furn.FurnQueryRequest;
import com.juzi.furnbackend.model.dto.furn.FurnUpdateRequest;
import org.springframework.validation.Errors;

/**
 * @author codejuzi
 * @description 针对表【tb_furn】的数据库操作Service
 * @createDate 2023-04-10 11:11:53
 */
public interface FurnService extends IService<Furn> {


    /**
     * 新增家具
     *
     * @param furnAddRequest 家具新增请求体信息
     * @param errors 校验错误信息
     * @return 新家具id
     */
    Integer furnSave(FurnAddRequest furnAddRequest, Errors errors);

    /**
     * 修改家具信息
     *
     * @param furnUpdateRequest 家具修改请求体信息
     * @return true - 修改成功
     */
    Boolean furnUpdate(FurnUpdateRequest furnUpdateRequest);

    /**
     * 分页查询家具信息
     *
     * @param pageRequest 分页查询信息
     * @return 分页信息
     */
    Page<Furn> furnListByPage(PageRequest pageRequest);

    /**
     * 按照条件分页查询家具信息
     *
     * @param furnQueryRequest 家具查询请求体信息
     * @return 分页信息
     */
    Page<Furn> furnQueryByPage(FurnQueryRequest furnQueryRequest);
}
