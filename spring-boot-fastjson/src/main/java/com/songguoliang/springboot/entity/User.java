package com.songguoliang.springboot.entity;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description
 * @Author sgl
 * @Date 2018-05-02 14:59
 */
@Table(name = "tbl_user")
public class User {
    @Id
    private Long userId;
    private String userName;
    private Integer userAge;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
}
