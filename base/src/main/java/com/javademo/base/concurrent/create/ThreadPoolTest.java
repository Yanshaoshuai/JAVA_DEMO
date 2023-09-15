package com.javademo.base.concurrent.create;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author YSS
 * @Date 2020/6/11 23:38
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();
        for(int i=0;i<100;i++){
            executorService.submit(new Task());
        }
    }
    public static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
