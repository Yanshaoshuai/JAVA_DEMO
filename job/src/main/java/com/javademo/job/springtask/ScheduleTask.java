package com.javademo.job.springtask;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class ScheduleTask {
    private final static Logger LOG = LoggerFactory.getLogger(ScheduleTask.class);

    private static int unsafe_count=0;
    private static int unsafe_count2=0;

    /**
     * 每隔3秒执行一次 任务执行需要4s
     */
    @Scheduled(fixedDelay = 1,timeUnit = TimeUnit.SECONDS)
    public void longTimeJob(){
        try {
            LOG.info("long time job start , thread name is {} , unsafe_count is {}",Thread.currentThread().getName(),unsafe_count++);
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Scheduled(cron = "* * * * * *")
    public void  cronJob(){
        try {
            LOG.info("cronJob start , thread name is {} , unsafe_count2 is {}",Thread.currentThread().getName(),unsafe_count2++);
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 默认job会等待上一次触发的任务执行完再执行本次任务
     * 使用 @EnableAsync + @Async将job改为异步方法
     * 则不会等待上一次任务执行完
     * 使用的是异步方法线程池 而不是定时任务线程池
     */
    @Scheduled(cron = "* * * * * *")
    @Async
    public void  cronJobNotWaitLastTaskFinish(){
        try {
            LOG.info("cronJobNotWaitLastTaskFinish start , thread name is {} , unsafe_count2 is {}",Thread.currentThread().getName(),unsafe_count2++);
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
