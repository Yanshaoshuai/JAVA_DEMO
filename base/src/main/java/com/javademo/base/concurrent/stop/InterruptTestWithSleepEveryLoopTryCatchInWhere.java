package com.javademo.base.concurrent.stop;

/**
 * @Author YSS
 * @Date 2020/6/12 1:28
 */
public class InterruptTestWithSleepEveryLoopTryCatchInWhere {
    public static void main(String[] args) throws InterruptedException {
        Runnable target=()->{
            int num=0;
                while (!Thread.currentThread().isInterrupted()&&num<10000){
                    if(num%100==0){
                        System.out.println(num+"是100整数倍");
                    }
                    num++;
                        try {
                             Thread.sleep(10);
                        } catch (InterruptedException e) {
                            //sleep 被打断抛出异常 会清除标志位
                            e.printStackTrace();
                            //重置中断标志位
                            //不重置不会跳出where
                            //Thread.currentThread().interrupt();
                        }
                }

        };

        Thread thread=new Thread(target);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
