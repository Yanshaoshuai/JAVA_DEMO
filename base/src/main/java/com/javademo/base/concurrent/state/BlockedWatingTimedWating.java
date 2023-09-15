package com.javademo.base.concurrent.state;

/**
 * @Author YSS
 * @Date 2020/6/12 16:11
 */
public class BlockedWatingTimedWating {
    public  synchronized void sync(){
        try {
            Thread.sleep(1000);
            wait();
        } catch (InterruptedException e) {
            System.out.println("BlockedWatingTimedWating#sync被中断");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockedWatingTimedWating bwtw=new BlockedWatingTimedWating();
        Runnable target=()->{
            bwtw.sync();
        };
        Thread thread1=new Thread(target);
        Thread thread2=new Thread(target);
        thread1.start();
        thread2.start();
        Thread.sleep(10);
        System.out.println(thread1.getState());
        System.out.println(thread2.getState());
        Thread.sleep(1300);
        System.out.println(thread1.getState());
    }
}
