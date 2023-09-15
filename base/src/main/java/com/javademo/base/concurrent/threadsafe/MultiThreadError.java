package com.javademo.base.concurrent.threadsafe;

/**
 * @Author YSS
 * @Date 2020/6/13 17:30
 */
public class MultiThreadError {
    private static int count=0;
    public static void main(String[] args) throws InterruptedException {
        Runnable target=()->{
            for (int i=0;i<10000;i++){
                count++;
            }
        };
        Thread thread1=new Thread(target);
        Thread thread2=new Thread(target);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        //小于20000
        System.out.println(count);
    }
}
