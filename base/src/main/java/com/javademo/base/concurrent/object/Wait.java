package com.javademo.base.concurrent.object;

/**
 * @Author YSS
 * @Date 2020/6/12 17:41
 */
public class Wait {
    private static Object object=new Object();
    public static void main(String[] args) throws InterruptedException {
        Runnable target1=()->{
            synchronized (object){
                System.out.println(Thread.currentThread().getName()+"获取到了锁");
                try {
                    //调用wait释放锁
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"又获取到了锁");
            }
        };
        Runnable target2=()->{
            synchronized (object){
                System.out.println(Thread.currentThread().getName()+"获取到了锁");
                //随机唤醒一个
                object.notify();
                System.out.println(Thread.currentThread().getName()+"调用了notify");
            }
        };
        Thread thread1=new Thread(target1);
        Thread thread2=new Thread(target2);
        thread1.start();
        Thread.sleep(1000);
        thread2.start();
    }
}
