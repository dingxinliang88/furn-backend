package com.juzi.furnbackend.mapper;

import com.juzi.furnbackend.model.domain.Furn;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author codejuzi
 * @description 针对表【tb_furn】的数据库操作Mapper
 * @createDate 2023-04-10 11:11:53
 * @Entity com.juzi.furnbackend.model.domain.Furn
 */
@Mapper
public interface FurnMapper extends BaseMapper<Furn> {

}




