package com.javademo.base.algorithm.mooc.systemclass.datastruct;

/**
 * @Author Mr.Yan
 * @Date 2021/12/19 16:51
 **/
public interface Stack<E> {
    void push(E e);

    E pop();

    E peek();

    int getSize();

    boolean isEmpty();
}
