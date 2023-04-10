package com.juzi.furnbackend.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juzi.furnbackend.common.ErrorCode;
import com.juzi.furnbackend.common.PageRequest;
import com.juzi.furnbackend.model.domain.Furn;
import com.juzi.furnbackend.model.dto.furn.FurnAddRequest;
import com.juzi.furnbackend.model.dto.furn.FurnDeleteRequest;
import com.juzi.furnbackend.model.dto.furn.FurnQueryRequest;
import com.juzi.furnbackend.model.dto.furn.FurnUpdateRequest;
import com.juzi.furnbackend.service.FurnService;
import com.juzi.furnbackend.mapper.FurnMapper;
import com.juzi.furnbackend.utils.ThrowUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import static com.juzi.furnbackend.constant.CommonConstants.ERROR_ID;
import static com.juzi.furnbackend.constant.CommonConstants.ERROR_MAP_INIT_SIZE;

/**
 * @author codejuzi
 * @description 针对表【tb_furn】的数据库操作Service实现
 * @createDate 2023-04-10 11:11:53
 */
@Service
public class FurnServiceImpl extends ServiceImpl<FurnMapper, Furn>
        implements FurnService {

    @Override
    public Integer furnSave(FurnAddRequest furnAddRequest, Errors errors) {

        ThrowUtil.throwIf(furnAddRequest == null, ErrorCode.PARAM_ERROR);
        Furn furn = new Furn();
        BeanUtils.copyProperties(furnAddRequest, furn);
        Map<String, Object> map = new HashMap<>(ERROR_MAP_INIT_SIZE);
        List<FieldError> fieldErrors = errors.getFieldErrors();
        for (FieldError e : fieldErrors) {
            map.put(e.getField(), e.getDefaultMessage());
        }
        if (map.isEmpty()) {
            this.save(furn);
            return furn.getId();
        }
        return ERROR_ID;
    }

    @Override
    public Boolean furnUpdate(FurnUpdateRequest furnUpdateRequest) {
        ThrowUtil.throwIf(furnUpdateRequest == null || furnUpdateRequest.getId() <= 0, ErrorCode.PARAM_ERROR);
        Integer id = furnUpdateRequest.getId();
        String name = furnUpdateRequest.getName();
        String maker = furnUpdateRequest.getMaker();
        BigDecimal price = furnUpdateRequest.getPrice();
        Integer sales = furnUpdateRequest.getSales();
        Integer stock = furnUpdateRequest.getStock();
        // 封装条件
        LambdaUpdateWrapper<Furn> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Furn::getId, id);
        updateWrapper.set(StringUtils.isNotBlank(name), Furn::getName, name)
                .set(StringUtils.isNotBlank(maker), Furn::getMaker, maker)
                .set(ObjectUtils.isNotEmpty(price), Furn::getPrice, price)
                .set(ObjectUtils.isNotEmpty(sales), Furn::getSales, sales)
                .set(ObjectUtils.isNotEmpty(stock), Furn::getStock, stock);
        // 修改
        return this.update(updateWrapper);
    }

    @Override
    public Page<Furn> furnListByPage(PageRequest pageRequest) {
        ThrowUtil.throwIf(pageRequest == null || pageRequest.getPageSize() > 20, ErrorCode.PARAM_ERROR);
        Integer pageNum = pageRequest.getPageNum();
        Integer pageSize = pageRequest.getPageSize();
        return this.page(new Page<>(pageNum, pageSize));
    }

    @Override
    public Page<Furn> furnQueryByPage(FurnQueryRequest furnQueryRequest) {
        ThrowUtil.throwIf(furnQueryRequest == null, ErrorCode.PARAM_ERROR);
        String searchText = furnQueryRequest.getSearchText();
        Integer pageNum = furnQueryRequest.getPageNum();
        Integer pageSize = furnQueryRequest.getPageSize();
        // 查询
        LambdaQueryWrapper<Furn> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(searchText), Furn::getName, searchText)
                .or()
                .like(StringUtils.isNotBlank(searchText), Furn::getMaker, searchText);
        return this.page(new Page<>(pageNum, pageSize), queryWrapper);
    }
}




