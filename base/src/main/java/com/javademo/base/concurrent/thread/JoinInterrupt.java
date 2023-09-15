package com.javademo.base.concurrent.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author YSS
 * @Date 2020/6/12 22:12
 */
public class JoinInterrupt {
    public static void main(String[] args) {
        Thread mainThread=Thread.currentThread();
        Runnable target=()->{
            System.out.println("子线程开始执行");
            try {
                mainThread.interrupt();
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                System.out.println("子线程被中断");
                //e.printStackTrace();
            }
            System.out.println("子线程运行结束");
        };
        Thread thread1=new Thread(target);
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            System.out.println("主线程被中断");
            thread1.interrupt();
            //e.printStackTrace();
        }
    }
}
