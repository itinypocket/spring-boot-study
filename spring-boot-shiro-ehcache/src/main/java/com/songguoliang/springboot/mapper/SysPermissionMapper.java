package com.songguoliang.springboot.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author sgl
 * @Date 2018-06-11 17:21
 */
public interface SysPermissionMapper {
    List<String> selectPermissionByUserId(@Param("userId") long userId);
}
