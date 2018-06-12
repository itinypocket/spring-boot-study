package com.songguoliang.springboot.mapper;

import com.songguoliang.springboot.entity.SysUser;

/**
 * @Description
 * @Author sgl
 * @Date 2018-06-11 17:19
 */
public interface SysUserMapper {
    SysUser findByUserName(String userName);
}
