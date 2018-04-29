package com.songguoliang.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author sgl
 * @Date 2018-04-26 14:19
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello,Spring Boot!";
    }
}
