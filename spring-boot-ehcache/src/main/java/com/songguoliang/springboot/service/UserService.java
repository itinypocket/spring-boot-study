package com.songguoliang.springboot.service;

import com.github.pagehelper.Page;
import com.songguoliang.springboot.entity.User;
import com.songguoliang.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 使用ehcache.xml配置users缓存，用用户id作为缓存主键
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "users",key = "#id")
    public User selectById(long id) {
        System.out.println("没有缓存，开始查询数据库……");
        return userMapper.selectByPrimaryKey(id);
    }

    @CacheEvict(value = "users",key = "#id")
    public void evictUser(Long id) {
        System.out.println("evict user:" + id);
    }
}
