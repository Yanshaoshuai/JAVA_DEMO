package com.javademo.base.concurrent.object;

/**
 * @Author YSS
 * @Date 2020/6/12 18:57
 * 交替打印奇偶数
 */
public class OddEvenNumbersPrint {
    private static int count=0;
    private static Object lock=new Object();
    public static void main(String[] args) {
        Runnable printTarget=()->{
                while (count<=100){
                    synchronized (lock){
                        System.out.println(Thread.currentThread().getName()+"print number "+count++);
                        lock.notify();
                        if(count<=100){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        };
        Thread thread1=new Thread(printTarget);
        Thread thread2=new Thread(printTarget);
        thread1.start();
        thread2.start();
    }
}
