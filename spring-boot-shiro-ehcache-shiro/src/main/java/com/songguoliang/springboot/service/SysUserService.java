package com.songguoliang.springboot.service;

import com.songguoliang.springboot.entity.SysUser;
import com.songguoliang.springboot.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author sgl
 * @Date 2018-06-11 17:10
 */
@Service
public class SysUserService {
    @Autowired
    private SysUserMapper userMapper;

    @Cacheable(cacheNames = "users", key = "'sysuser:'+#userName")
    public SysUser findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }
}
