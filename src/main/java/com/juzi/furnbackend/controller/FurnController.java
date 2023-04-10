package com.juzi.furnbackend.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.juzi.furnbackend.common.BaseResponse;
import com.juzi.furnbackend.common.ErrorCode;
import com.juzi.furnbackend.common.PageRequest;
import com.juzi.furnbackend.model.domain.Furn;
import com.juzi.furnbackend.model.dto.furn.FurnAddRequest;
import com.juzi.furnbackend.model.dto.furn.FurnDeleteRequest;
import com.juzi.furnbackend.model.dto.furn.FurnQueryRequest;
import com.juzi.furnbackend.model.dto.furn.FurnUpdateRequest;
import com.juzi.furnbackend.service.FurnService;
import com.juzi.furnbackend.utils.ResultUtil;
import com.juzi.furnbackend.utils.ThrowUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author codejuzi
 * @CreateTime 2023/4/10
 */
@Slf4j
@RestController
@RequestMapping("/furn")
public class FurnController {

    @Resource
    private FurnService furnService;

    @PostMapping("/save")
    public BaseResponse<Integer> furnAdd(@Validated @RequestBody FurnAddRequest furnAddRequest, Errors errors) {
        ThrowUtil.throwIf(furnAddRequest == null, ErrorCode.PARAM_ERROR);
        Integer furnId = furnService.furnSave(furnAddRequest, errors);
        return ResultUtil.success(furnId);
    }

    @GetMapping("/list")
    public BaseResponse<List<Furn>> furnList() {
        List<Furn> furnList = furnService.list();
        return ResultUtil.success(furnList);
    }

    @PutMapping("/update")
    public BaseResponse<Boolean> furnUpdate(@RequestBody FurnUpdateRequest furnUpdateRequest) {
        ThrowUtil.throwIf(furnUpdateRequest == null
                || furnUpdateRequest.getId() == null
                || furnUpdateRequest.getId() <= 0, ErrorCode.PARAM_ERROR);
        Boolean update = furnService.furnUpdate(furnUpdateRequest);
        return ResultUtil.success(update);
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse<Boolean> furnDelete(@PathVariable("id") Integer id) {
        ThrowUtil.throwIf(id == null || id <= 0, ErrorCode.PARAM_ERROR);
        Boolean delete = furnService.removeById(id);
        return ResultUtil.success(delete);
    }

    @PostMapping("/list/page")
    public BaseResponse<Page<Furn>> furnListByPage(@RequestBody PageRequest pageRequest) {
        ThrowUtil.throwIf(pageRequest == null, ErrorCode.PARAM_ERROR);
        Page<Furn> furnPage = furnService.furnListByPage(pageRequest);
        return ResultUtil.success(furnPage);
    }

    @PostMapping("/list/query")
    public BaseResponse<Page<Furn>> furnQueryByPage(@RequestBody FurnQueryRequest furnQueryRequest) {
        ThrowUtil.throwIf(furnQueryRequest == null, ErrorCode.PARAM_ERROR);
        Page<Furn> furnPage = furnService.furnQueryByPage(furnQueryRequest);
        return ResultUtil.success(furnPage);
    }
}
