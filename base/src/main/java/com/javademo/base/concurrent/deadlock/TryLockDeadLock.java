package com.javademo.base.concurrent.deadlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * tryLock 尝试获取锁-->获取不到放弃
 * @Author YSS
 * @Date 2020/6/15 0:23
 */
public class TryLockDeadLock {
    public static void main(String[] args) {
        Lock lock1=new ReentrantLock();
        Lock lock2=new ReentrantLock();
        Thread thread1=new Thread(()->{
            for(int i=0;i<1000;i++){
                try {
                    if(lock1.tryLock(100,TimeUnit.NANOSECONDS)){
                        System.out.println(Thread.currentThread().getName()+"获取到了lock1");
                        TimeUnit.SECONDS.sleep(1);
                        if (lock2.tryLock(100,TimeUnit.NANOSECONDS)){
                            System.out.println(Thread.currentThread().getName()+"获取到了lock2");
                            System.out.println(Thread.currentThread().getName()+"获取到了两把锁");
                            lock2.unlock();
                        }else {
                            System.out.println( Thread.currentThread().getName()+"尝试获取锁2失败");
                        }
                        lock1.unlock();
                    }else {
                        System.out.println(Thread.currentThread().getName()+"尝试获取锁1失败");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        Thread thread2=new Thread(()->{
            for(int i=0;i<1000;i++) {
                try {
                    if (lock2.tryLock(100, TimeUnit.NANOSECONDS)) {
                        System.out.println(Thread.currentThread().getName() + "获取到了lock2");
                        TimeUnit.SECONDS.sleep(1);
                        if (lock1.tryLock(100, TimeUnit.NANOSECONDS)) {
                            System.out.println(Thread.currentThread().getName() + "获取到了lock1");
                            System.out.println(Thread.currentThread().getName() + "获取到了两把锁");
                            lock1.unlock();
                        } else {
                            System.out.println(Thread.currentThread().getName() + "尝试获取锁1失败");
                        }
                        lock2.unlock();
                    } else {
                        System.out.println(Thread.currentThread().getName() + "尝试获取锁2失败");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
