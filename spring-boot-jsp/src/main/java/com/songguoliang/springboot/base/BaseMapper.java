package com.songguoliang.springboot.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Description 自己的Mapper基类，主要不能放到mapper下
 * @Author sgl
 * @Date 2018-05-07 16:57
 */
public interface BaseMapper<T> extends Mapper<T>,MySqlMapper<T>{
}
