package com.javademo.base.concurrent.threadsafe;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 统计错误次数和哪次出错
 * @Author YSS
 * @Date 2020/6/13 17:58
 */
public class WhereError {
    private static int count=0;
    public static void main(String[] args) throws InterruptedException {
        Object lock=new Object();
        CyclicBarrier cyclicBarrier1=new CyclicBarrier(2);
        CyclicBarrier cyclicBarrier2=new CyclicBarrier(2);
        boolean [] marked = new boolean[40000];
        AtomicInteger rightNumber = new AtomicInteger();
        AtomicInteger wrongNumber = new AtomicInteger();

        Runnable target=()->{
            for (int i=0;i<10000;i++){
                try {
                    cyclicBarrier2.reset();
                    cyclicBarrier1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                count++;
                try {
                    cyclicBarrier1.reset();
                    cyclicBarrier2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                rightNumber.incrementAndGet();
                synchronized (lock){
                    if(marked[count]&&marked[count-1]){
                        wrongNumber.incrementAndGet();
                        System.out.println("发生错误"+count);
                    }
                    marked[count]=true;
                }
            }
        };
        Thread thread1=new Thread(target);
        Thread thread2=new Thread(target);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        //小于20000
        System.out.println("表现出来次数"+count);
        System.out.println("实际运行次数"+rightNumber);
        System.out.println("错误次数"+wrongNumber);
    }
}
