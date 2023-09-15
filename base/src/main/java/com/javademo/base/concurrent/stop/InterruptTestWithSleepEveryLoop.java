package com.javademo.base.concurrent.stop;

/**
 * @Author YSS
 * @Date 2020/6/12 1:22
 */
public class InterruptTestWithSleepEveryLoop {
    public static void main(String[] args) throws InterruptedException {
        Runnable target=()->{
            int num=0;
            try {
                while (num<10000){
                    if(num%100==0){
                        System.out.println(num+"是100整数倍");
                    }
                    num++;

                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                //sleep 被打断抛出异常
                e.printStackTrace();
            }
        };

        Thread thread=new Thread(target);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
