package com.songguoliang.mybatis.mapper;

import com.songguoliang.mybatis.entity.User;

import java.util.List;

/**
 * @Description
 * @Author sgl
 * @Date 2018-05-02 15:02
 */
public interface UserMapper {

    List<User> getUsers();
}
