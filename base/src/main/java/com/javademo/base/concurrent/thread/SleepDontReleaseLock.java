package com.javademo.base.concurrent.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author YSS
 * @Date 2020/6/12 21:44
 */
public class SleepDontReleaseLock implements Runnable{
    private  Lock lock=new ReentrantLock();
    @Override
    public void run() {
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"获取到了锁");
            Thread.sleep(5000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SleepDontReleaseLock target=new SleepDontReleaseLock();
        Thread thread1=new Thread(target);
        Thread thread2=new Thread(target);
        thread1.start();
        thread2.start();
    }
}
