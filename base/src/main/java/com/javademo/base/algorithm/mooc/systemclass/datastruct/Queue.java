package com.javademo.base.algorithm.mooc.systemclass.datastruct;

/**
 * @Author Mr.Yan
 * @Date 2021/12/19 19:36
 **/
public interface Queue <E>{
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
