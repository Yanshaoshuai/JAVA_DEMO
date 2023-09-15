package com.javademo.base.concurrent.object;

/**
 * 只能释放当前monitor的锁
 * @Author YSS
 * @Date 2020/6/12 18:05
 */
public class JustReleaseCurrentMonitor {
    private static Object resourceA=new Object();
    private static Object resourceB=new Object();

    public static void main(String[] args) throws InterruptedException {
        Runnable target1=()->{
            synchronized (resourceA){
                System.out.println(Thread.currentThread().getName()+"获取了resourceA的锁");
                synchronized (resourceB){
                    System.out.println(Thread.currentThread().getName()+"获取了resourceB的锁");
                        try {
                            resourceA.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                }
            }
        };
        Runnable target2=()->{
            synchronized (resourceA){
                System.out.println(Thread.currentThread().getName()+"获取了resourceA的锁");
                System.out.println(Thread.currentThread().getName()+"尝试获取resourceB的锁");
                synchronized (resourceB){
                    System.out.println(Thread.currentThread().getName()+"获取了resourceB的锁");
                }
            }
        };
        Thread thread1=new Thread(target1);
        Thread thread2=new Thread(target2);
        thread1.start();
        Thread.sleep(1000);
        thread2.start();
    }
}
