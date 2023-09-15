package com.javademo.base.concurrent.threadpool;

import java.util.concurrent.*;

/**
 * @Author Mr.Yan
 * @Date 2020 / 10 /10 00:40
 **/
public class Test {
    public static void main(String[] args) {
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(
                3,//指定了线程池里的线程数量，核心线程池大小
                5,// 指定了线程池里的最大线程数量
                1L,//当线程池线程数量大于corePoolSize时候，多出来的空闲线程，多长时间会被销毁。
                TimeUnit.SECONDS,//时间单位
                new ArrayBlockingQueue<>(3),//workQueue 任务队列，用于存放提交但是尚未被执行的任务
                Executors.defaultThreadFactory(),//线程工厂,用于创建线程
                new ThreadPoolExecutor.AbortPolicy()//拒绝策略
        );
        for (int i = 0; i < 9; i++) {
            threadPoolExecutor.execute(()->{
                System.out.println(Thread.currentThread().getName()+"办理业务");
            });
        }
        threadPoolExecutor.shutdown();
    }
}
