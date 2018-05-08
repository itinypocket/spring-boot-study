package com.songguoliang.springboot.mapper;

import com.github.pagehelper.Page;
import com.songguoliang.springboot.base.BaseMapper;
import com.songguoliang.springboot.entity.User;

/**
 * @Description
 * @Author sgl
 * @Date 2018-05-02 15:02
 */
public interface UserMapper extends BaseMapper<User> {

    Page<User> getUsers();
}
