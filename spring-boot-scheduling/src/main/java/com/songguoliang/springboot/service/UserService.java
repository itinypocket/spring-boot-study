package com.songguoliang.springboot.service;

import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author sgl
 * @Date 2018-06-26 11:52
 */
@Service
public class UserService {

    public void test(){
        System.out.println("我是注入的service中的方法");
    }

}
