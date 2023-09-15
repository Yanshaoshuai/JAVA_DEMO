package com.javademo.base.concurrent.object;

import java.util.Date;
import java.util.LinkedList;

/**
 * 生产者消费者模式
 * @Author YSS
 * @Date 2020/6/12 18:28
 */
public class ProducerConsumerModel {
    public static void main(String[] args) {
        EventStorage storage=new EventStorage(10,new LinkedList<>());
        Producer producer=new Producer(storage);
        Consumer consumer=new Consumer(storage);
        Thread producerThread=new Thread(producer);
        Thread consumerThread=new Thread(consumer);
        producerThread.start();
        consumerThread.start();
    }
}
class Producer implements Runnable{
    private EventStorage storage;
    public Producer(EventStorage storage) {
        this.storage = storage;
    }
    @Override
    public void run() {
        for (int i=0;i<1000;i++){
            storage.put(new Date());
        }
    }
}

class Consumer implements Runnable{
    private EventStorage storage;
    public Consumer(EventStorage storage) {
        this.storage = storage;
    }
    @Override
    public void run() {
        for (int i=0;i<1000;i++){
            storage.take();
        }
    }
}
class EventStorage{
    private int maxSize;
    private LinkedList<Date> storage;

    public EventStorage(int maxSize, LinkedList<Date> storage) {
        this.maxSize = maxSize;
        this.storage = storage;
    }
    public synchronized void put(Date date){
        while (storage.size()==maxSize){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.add(date);
        System.out.println("添加了一个元素"+date+"目前仓库里有"+storage.size()+"数据");
        notify();
    }
    public synchronized void take(){
        while (storage.size()==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("取出一个元素"+storage.poll()+"还剩"+storage.size()+"个元素");
        notify();
    }
}
