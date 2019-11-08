package com.jx.douyin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jx.douyin.domain.Douyin;

/**
 * @Description TODO
 * @Author jx
 * @Date 2019/5/22 10:25
 */
public interface DyServcie extends IService<Douyin> {
    void dyinfo(String url,String mail);
}
