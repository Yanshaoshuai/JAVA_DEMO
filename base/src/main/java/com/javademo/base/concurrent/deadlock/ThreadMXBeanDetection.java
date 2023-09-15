package com.javademo.base.concurrent.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @Author YSS
 * @Date 2020/6/14 22:49
 */
public class ThreadMXBeanDetection {
    public static void main(String[] args) throws InterruptedException {
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
        TimeUnit.SECONDS.sleep(1);
        //检测死锁
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();
        Arrays.stream(deadlockedThreads).forEach(deadlockedThread->{
            ThreadInfo threadInfo = threadMXBean.getThreadInfo(deadlockedThread);
            System.out.println(threadInfo);
        });
    }

}
