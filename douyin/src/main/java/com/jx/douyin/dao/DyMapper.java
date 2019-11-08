package com.jx.douyin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jx.douyin.domain.Douyin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DyMapper extends BaseMapper<Douyin> {
    Douyin lastData();
}
