package com.javademo.base.concurrent.volatile_;

/**
 * @Author YSS
 * @Date 2020/6/14 17:33
 */
public class NotAtomic {
    private static volatile int count=0;
    public static void main(String[] args) throws InterruptedException {
        Runnable target=()->{
            for(int i=0;i<10000;i++){
                count++;
            }
        };
        Thread thread1 = new Thread(target);
        Thread thread2 = new Thread(target);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(count);
    }
}
