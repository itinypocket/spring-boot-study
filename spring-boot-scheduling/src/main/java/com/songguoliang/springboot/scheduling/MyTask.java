package com.songguoliang.springboot.scheduling;

import com.songguoliang.springboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author sgl
 * @Date 2018-06-26 10:07
 */
@Component
public class MyTask {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyTask.class);

    private static final long SECOND = 1000;

    /**
     * 注入service
     */
    @Autowired
    private UserService userService;

    /**
     * 固定间隔3秒，可以引用变量
     * fixedRate：以每次开始时间作为测量，间隔固定时间
     */
    //@Scheduled(fixedRate = 3 * SECOND)
    public void task1() {
        LOGGER.info("当前时间：{}\t\t任务：fixedRate task，每3秒执行一次", System.currentTimeMillis());
        userService.test();
    }

    /**
     * 固定延迟3秒，从前一次任务结束开始计算，延迟3秒执行
     */
    //@Scheduled(fixedDelay = 3000)
    public void task3(){
        //do something
    }

    /**
     * cron表达式，每5秒执行
     */
    @Scheduled(cron = "*/5 * * * * ?")
    public void task2() {
        LOGGER.info("当前时间：{}\t\t任务：cron task，每5秒执行一次", System.currentTimeMillis());
    }


}
