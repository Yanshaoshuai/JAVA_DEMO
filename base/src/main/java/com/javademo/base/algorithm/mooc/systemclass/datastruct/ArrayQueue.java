package com.javademo.base.algorithm.mooc.systemclass.datastruct;

/**
 * @Author Mr.Yan
 * @Date 2021/12/19 19:37
 **/
public class ArrayQueue<E> implements Queue<E>{
    private Array<E> data;

    public ArrayQueue(int capacity) {
        this.data = new Array<>(capacity);
    }

    public ArrayQueue() {
        this.data=new Array<>();
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        data.addLast(e);
    }

    @Override
    public E dequeue() {
        return data.removeFirst();
    }

    @Override
    public E getFront() {
        return data.getFirst();
    }
    @Override
    public String toString() {
        StringBuilder dataStr = new StringBuilder();
        dataStr.append("Queue front [");
        for (int i = 0; i < data.getSize(); i++) {
            dataStr.append(data.get(i));
            if (i == data.getSize() - 1) {
                dataStr.append("] tail");
            } else {
                dataStr.append(",");
            }
        }
        return String.format("%s",dataStr);
    }
    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue=new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i);
        }
        System.out.println(arrayQueue);
        Integer dequeue = arrayQueue.dequeue();
        System.out.println(dequeue);
        System.out.println(arrayQueue);
    }
}
