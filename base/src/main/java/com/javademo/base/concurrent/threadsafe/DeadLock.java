package com.javademo.base.concurrent.threadsafe;

/**
 * @Author YSS
 * @Date 2020/6/13 18:18
 */
public class DeadLock {
    public static void main(String[] args) {
        Object lock1=new Object();
        Object lock2=new Object();
        Thread thread1=new Thread(()->{
            synchronized (lock1){
                System.out.println(Thread.currentThread().getName()+"获取到了lock1");
                synchronized (lock2){
                    System.out.println(Thread.currentThread().getName()+"获取到了lock2");
                }
            }
        });
        Thread thread2=new Thread(()->{
            synchronized (lock2){
                System.out.println(Thread.currentThread().getName()+"获取到了lock2");
                synchronized (lock1){
                    System.out.println(Thread.currentThread().getName()+"获取到了lock1");
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
