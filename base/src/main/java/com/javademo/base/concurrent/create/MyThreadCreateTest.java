package com.javademo.base.concurrent.create;

/**
 * @Author YSS
 * @Date 2020/6/11 23:15
 */
public class MyThreadCreateTest {

    public static void main(String[] args) {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable#run");
            }
        }){
            @Override
            public void run() {
                System.out.println("Thread#Child#run");
            }
        };
        //会调用子类的方法
        thread.start();
    }
}
