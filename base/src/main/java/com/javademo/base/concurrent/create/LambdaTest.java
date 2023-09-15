package com.javademo.base.concurrent.create;

/**
 * @Author YSS
 * @Date 2020/6/11 23:59
 */
public class LambdaTest {
    public static void main(String[] args) {
        Thread thread=new Thread(()->{
            System.out.println("lambda runnable");
        });
        thread.start();
    }
}
