package com.javademo.base.concurrent.deadlock;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 哲学家就餐  死锁
 * @Author YSS
 * @Date 2020/6/14 23:37
 */
public class DiningPhilosophers {
    private final static int SIZE=5;
    public static void main(String[] args) {
        Philosopher[] philosophers=new Philosopher[SIZE];
        Object[] chopsticks=new Object[SIZE];
        for (int j=0;j<SIZE;j++){
            chopsticks[j]=new Object();
        }
        for(int i=0;i<SIZE;i++){
            Object leftChopstick=chopsticks[i];
            Object rightChopstick=chopsticks[(i+1)%SIZE];
            philosophers[i]=new Philosopher(leftChopstick,rightChopstick);
            Thread thread=new Thread(philosophers[i],"哲学家"+(i+1));
            thread.start();
        }
    }
    static class Philosopher implements Runnable{
        private static Random random=new Random();
        public Philosopher(Object rightChopstick, Object leftChopstick) {
            this.rightChopstick = rightChopstick;
            this.leftChopstick = leftChopstick;
        }
        private Object rightChopstick;
        private Object leftChopstick;
        @Override
        public void run() {
            while (true){
                doAction("Thinking");
                synchronized (leftChopstick){
                    doAction("Pick up left chopstick");
                    synchronized (rightChopstick){
                        doAction("Pick up right chopstick-eating");
                        try {
                            TimeUnit.NANOSECONDS.sleep(random.nextInt(1000));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        doAction("Put down right chopstick");
                    }
                    doAction("Put down left chopstick");
                }
            }
        }
        private void doAction(String action) {
            System.out.println(Thread.currentThread().getName()+"--->"+action);
        }
    }
}
