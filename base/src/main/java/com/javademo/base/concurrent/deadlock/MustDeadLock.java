package com.javademo.base.concurrent.deadlock;

import java.util.concurrent.TimeUnit;

/**
 * 必会产生死锁
 * @Author YSS
 * @Date 2020/6/14 21:38
 */
public class MustDeadLock {
    public static void main(String[] args) {
        Object lock1=new Object();
        Object lock2=new Object();
        Thread thread1=new Thread(()->{
            synchronized (lock1){
                System.out.println(Thread.currentThread().getName()+"获取到了lock1");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println(Thread.currentThread().getName()+"获取到了lock2");
                }
            }
        });
        Thread thread2=new Thread(()->{
            synchronized (lock2){
                System.out.println(Thread.currentThread().getName()+"获取到了lock2");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println(Thread.currentThread().getName()+"获取到了lock1");
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
