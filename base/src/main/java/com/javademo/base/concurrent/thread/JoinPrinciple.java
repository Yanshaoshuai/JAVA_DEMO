package com.javademo.base.concurrent.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author YSS
 * @Date 2020/6/12 22:34
 */
public class JoinPrinciple {
    public static void main(String[] args) throws InterruptedException {
        Runnable target=()->{
            System.out.println(Thread.currentThread().getName()+"开始执行");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"执行完毕");
        };
        Thread thread=new Thread(target);
        thread.start();
        synchronized (thread){
            thread.wait();
        }
        System.out.println("所有线程执行完毕");
    }
}
