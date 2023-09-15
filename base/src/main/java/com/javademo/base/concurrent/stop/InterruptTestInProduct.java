package com.javademo.base.concurrent.stop;

/**
 * @Author YSS
 * @Date 2020/6/12 1:38
 */
public class InterruptTestInProduct implements Runnable {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            System.out.println("InterruptTestInProduct# run");
//            catchInMethod();
            try {
                catchOutMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * 错误案例
     * 内部捕获在外部无感知
     */
    public void catchInMethod(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 正确案例
     * 向上抛出异常
     * @throws InterruptedException
     */
    public void catchOutMethod() throws InterruptedException {
            Thread.sleep(2000);
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable target=new InterruptTestInProduct();
        Thread thread=new Thread(target);
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
