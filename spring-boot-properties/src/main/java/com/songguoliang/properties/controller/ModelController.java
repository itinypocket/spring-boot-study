package com.songguoliang.properties.controller;

import com.songguoliang.properties.model.RandomData;
import com.songguoliang.properties.model.TestEntity;
import com.songguoliang.properties.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author sgl
 * @Date 2018-04-27 15:31
 */
@RestController
public class ModelController {
    /**
     * 注入user
     */
    @Autowired
    private User user;

    @Autowired
    private RandomData randomData;

    @Autowired
    private TestEntity testEntity;

    @GetMapping("/say")
    public String hello() {
        return "大家好，我的名字是" + user.getName() + "，我今年" + user.getAge() + "岁了，我在" + user.getAddress() + "工作！";
    }

    @GetMapping("/random")
    public RandomData random() {
        return randomData;
    }

    @GetMapping("/test")
    public TestEntity getTestEntity() {
        return testEntity;
    }
}
