package com.javademo.base.concurrent.stop;

/**
 * @Author YSS
 * @Date 2020/6/12 15:36
 */
public class InterruptMethodTest {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne=new Thread(){
            @Override
            public void run() {
                while (true){

                }
            }
        };
        threadOne.start();
        threadOne.interrupt();
        Thread.sleep(1000);
        System.out.println(threadOne.isInterrupted());
        //相当于Thread.interrupted()
        // 操作的是当前线程的中断状态而不是threadOne的
        System.out.println(Thread.interrupted());
        System.out.println(Thread.interrupted());
        System.out.println(threadOne.isInterrupted());
    }
}
