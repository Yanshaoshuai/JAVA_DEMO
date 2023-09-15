package com.javademo.base.concurrent.stop;

/**
 * @Author YSS
 * @Date 2020/6/12 1:01
 */
public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Runnable target=()->{
            int num=0;
            while (!Thread.currentThread().isInterrupted()&&num<Integer.MAX_VALUE/2){
                if(num%10000==0){
                    System.out.println(num+"是10000整数倍");
                }
                num++;
            }
        };
        Thread thread=new Thread(target);
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
    }
}
