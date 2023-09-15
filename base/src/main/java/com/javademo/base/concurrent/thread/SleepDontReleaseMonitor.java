package com.javademo.base.concurrent.thread;

/**
 * @Author YSS
 * @Date 2020/6/12 21:40
 */
public class SleepDontReleaseMonitor {
    public static synchronized void sync()  {
        System.out.println(Thread.currentThread().getName()+"SleepDontReleaseMonitor#sync");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Runnable target = ()->{
          sync();
        };
        Thread thread1 = new Thread(target);
        Thread thread2=new Thread(target);
        thread1.start();
        thread2.start();
    }
}
