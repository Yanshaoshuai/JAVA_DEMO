package com.javademo.base.concurrent.object;

/**
 * @Author YSS
 * @Date 2020/6/12 19:09
 */
public class OddEvenNumbersPrintLow {
    private static int count=0;
    private static Object lock=new Object();
    public static void main(String[] args) {
        Runnable oddTarget=()->{
            while (count<100){
                synchronized (lock){
                    if((count&1)==1){
                        System.out.println(Thread.currentThread().getName()+"print number "+count++);
                    }
                }
            }
        };
        Runnable evenTarget=()->{
            while (count<=100){
                synchronized (lock){
                    if((count&1)==0){
                        System.out.println(Thread.currentThread().getName()+"print number "+count++);
                    }
                }
            }
        };
        Thread oddThread=new Thread(oddTarget,"oddThread");
        Thread evenThread=new Thread(evenTarget,"evenThread");
        oddThread.start();
        evenThread.start();
    }
}
