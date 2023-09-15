package com.javademo.base.concurrent.properties;

/**
 * @Author YSS
 * @Date 2020/6/13 16:25
 */
public class Name {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Runnable target=()->{
            System.out.println("thread");
        };
        Thread thread=new Thread(target);
        System.out.println(thread.getName());
    }
}
