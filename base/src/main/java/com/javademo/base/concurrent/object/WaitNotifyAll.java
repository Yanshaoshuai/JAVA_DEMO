package com.javademo.base.concurrent.object;

/**
 * @Author YSS
 * @Date 2020/6/12 17:50
 */
public class WaitNotifyAll {
    private static Object object=new Object();
    public static void main(String[] args) throws InterruptedException {
        Runnable targetWait=()->{
            synchronized (object){
                try {
                    System.out.println(Thread.currentThread().getName()+"释放锁");
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"又获得锁");
            }
        };
        Thread thread1=new Thread(targetWait);
        Thread thread2=new Thread(targetWait);
        Thread thread3=new Thread(()->{
            synchronized (object){
                System.out.println(Thread.currentThread().getName()+"唤醒所有");
                object.notifyAll();
            }
        });

        thread1.start();
        thread2.start();
        Thread.sleep(300);
        thread3.start();
    }
}
