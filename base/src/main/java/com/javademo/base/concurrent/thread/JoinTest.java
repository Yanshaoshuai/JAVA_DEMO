package com.javademo.base.concurrent.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author YSS
 * @Date 2020/6/12 22:05
 */
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread=Thread.currentThread();
        Runnable target=()->{
            System.out.println(Thread.currentThread().getName()+"开始执行");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"执行完毕");
            System.out.println("join时主线程状态:"+mainThread.getState());
        };
        Thread thread1=new Thread(target);
        Thread thread2=new Thread(target);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("所有线程执行完毕");
    }
}
