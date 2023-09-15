package com.javademo.base.concurrent.jmm;

import java.util.concurrent.TimeUnit;

/**
 * (1,1)
 * (3,1)
 * (3,3)
 *
 * (1,3) ---> 可见性问题
 * @Author YSS
 * @Date 2020/6/14 15:18
 */
public class FieldVisibility {
    private  int a=1,b=1;
    private  void change(){
        a=3;
        b=a;
    }
    private  void print(){
        System.out.println("("+a+","+b+")");
    }

    public static void main(String[] args) throws InterruptedException {
        while (true){
            FieldVisibility fieldVisibility=new FieldVisibility();
            Thread thread1=new Thread(()->{
                try {
                    TimeUnit.NANOSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                fieldVisibility.change();
            });
            Thread thread2=new Thread(()->{
                try {
                    TimeUnit.NANOSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                fieldVisibility.print();
            });
            thread2.start();
            thread1.start();
            thread1.join();
            thread2.join();
        }
    }
}
