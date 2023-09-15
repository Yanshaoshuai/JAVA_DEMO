package com.javademo.base.concurrent.stop;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 生产速度>消费速度
 * 消费停止,生产阻塞在put上
 * @Author YSS
 * @Date 2020/6/12 14:43
 */
public class VolatileWrongTest {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue blockingQueue=new ArrayBlockingQueue(10);
        Producer producer = new Producer(blockingQueue);
        Thread producerThread=new Thread(producer);
        producerThread.start();
        Consumer consumer=new Consumer(blockingQueue);
        Thread.sleep(1000);
        while (consumer.needMoreNumbers()){
            System.out.println(consumer.blockingQueue.take()+"被消费了");
            Thread.sleep(500);
        }
        //
        System.out.println("消费者不再需要更多数据");
        producer.stop=true;
        System.out.println(producer.stop);
    }
}
class Producer implements Runnable{
    public volatile boolean stop=false;
    private BlockingQueue blockingQueue;

    public Producer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }
    @Override
    public void run() {
        int num=0;
        try {
            while (!stop&&num<10000000){
                if(num%100==0){
                    blockingQueue.put(num);
                    System.out.println(num+" is add to blockingQueue");
                }
                num++;
                Thread.sleep(1);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
class Consumer{
    public BlockingQueue blockingQueue;

    public Consumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public boolean needMoreNumbers(){
        if(Math.random()>0.95){
            return false;
        }
        return true;
    }
}