package com.songguoliang.properties.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author sgl
 * @Date 2018-04-27 15:50
 */
@Component
@ConfigurationProperties(prefix = "test")
public class RandomData {
    private Integer randomInt;
    private Integer randomIntMax;
    private Integer randomIntMiddle;
    private Long randomLong;
    private String randomValue;
    private String randomUuid;

    public Integer getRandomInt() {
        return randomInt;
    }

    public void setRandomInt(Integer randomInt) {
        this.randomInt = randomInt;
    }

    public Integer getRandomIntMax() {
        return randomIntMax;
    }

    public void setRandomIntMax(Integer randomIntMax) {
        this.randomIntMax = randomIntMax;
    }

    public Integer getRandomIntMiddle() {
        return randomIntMiddle;
    }

    public void setRandomIntMiddle(Integer randomIntMiddle) {
        this.randomIntMiddle = randomIntMiddle;
    }

    public Long getRandomLong() {
        return randomLong;
    }

    public void setRandomLong(Long randomLong) {
        this.randomLong = randomLong;
    }

    public String getRandomValue() {
        return randomValue;
    }

    public void setRandomValue(String randomValue) {
        this.randomValue = randomValue;
    }

    public String getRandomUuid() {
        return randomUuid;
    }

    public void setRandomUuid(String randomUuid) {
        this.randomUuid = randomUuid;
    }
}
