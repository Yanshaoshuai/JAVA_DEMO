package com.javademo.base.concurrent.properties;

/**
 * @Author YSS
 * @Date 2020/6/13 16:24
 */
public class Id {
    public static void main(String[] args) {
        Thread thread=Thread.currentThread();
        System.out.println(thread.getId());
        Thread thread1=new Thread(()->{
            System.out.println("thread1");
        });
        System.out.println(thread1.getId());
    }
}
