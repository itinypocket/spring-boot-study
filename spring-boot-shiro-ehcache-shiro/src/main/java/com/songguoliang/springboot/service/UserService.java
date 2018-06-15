package com.songguoliang.springboot.service;

import com.github.pagehelper.Page;
import com.songguoliang.springboot.entity.User;
import com.songguoliang.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author sgl
 * @Date 2018-05-02 15:01
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Page<User> getUsers() {
        return userMapper.getUsers();
    }

    @Cacheable(cacheNames = "users", key = "'user:'+#id")
    public User selectById(long id){
        System.out.println("from db");
        return userMapper.selectByPrimaryKey(id);
    }
}
