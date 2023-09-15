package com.javademo.base.concurrent.stop;

/**
 * @Author YSS
 * @Date 2020/6/12 1:15
 */
public class InterruptTestWithSleep {
    public static void main(String[] args) throws InterruptedException {
        Runnable target=()->{
            int num=0;
            while (!Thread.currentThread().isInterrupted()&&num<300){
                if(num%100==0){
                    System.out.println(num+"是100整数倍");
                }
                num++;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                //sleep 被打断抛出异常
                e.printStackTrace();
            }
        };

        Thread thread=new Thread(target);
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
    }
}
