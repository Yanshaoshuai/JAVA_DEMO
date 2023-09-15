package com.javademo.base.concurrent.jmm;

import java.util.concurrent.CountDownLatch;

/**
 * x=0,y=1
 * x=1,y=0
 * x=1,y=1
 * x=0,y=0  -->重排序
 * 重排序演示
 * @Author YSS
 * @Date 2020/6/14 14:39
 */
public class OutOrderExecution {
   /* private static int x,y=0;
    private static int a,b=0;*/
    private static volatile int x,y=0;
    private static volatile int a,b=0;

    public static void main(String[] args) throws InterruptedException {
        int i=0;
        for(;;i++){
            CountDownLatch countDownLatch=new CountDownLatch(1);
            x=0;y=0;a=0;b=0;
            Thread thread1=new Thread(()->{
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a=1;
                x=b;
            });
            Thread thread2=new Thread(()->{
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                b=1;
                y=a;
            });
            thread1.start();
            thread2.start();
            countDownLatch.countDown();
            thread1.join();
            thread2.join();
            String result="第"+i+"次运行("+x+" ,"+y+")";
            if ((x==1&&y==1)||(x==0&&y==0)){
                System.out.println(result);
                break;
            }
                System.out.println(result);
        }

    }
}
