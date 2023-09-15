package com.javademo.base.concurrent.stop;

/**
 * @Author YSS
 * @Date 2020/6/12 14:34
 */
public class VolatileTest implements Runnable{
    private volatile boolean stop=false;
    @Override
    public void run() {
        int num=0;
        while (!stop){
            System.out.println("VolatileTest#run");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest target=new VolatileTest();
        Thread thread=new Thread(target);
        thread.start();
        Thread.sleep(1000);
        target.stop=true;
    }
}
