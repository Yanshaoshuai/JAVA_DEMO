package com.javademo.base.concurrent.threadexception;

import java.util.concurrent.TimeUnit;

/**
 * @Author YSS
 * @Date 2020/6/13 16:59
 */
public class UseMyUncaughtExceptionHandler {
    public static void main(String[] args) throws InterruptedException {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler("自定义异常处理器"));
        Runnable target=()->{
            throw new RuntimeException();
        };
        Thread thread1 = new Thread(target);
        thread1.start();
    }
}
