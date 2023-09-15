package com.javademo.base.algorithm.mooc.systemclass.datastruct;

/**
 * @Author Mr.Yan
 * @Date 2021/12/19 16:44
 **/
public class ArrayStack<E> implements Stack<E>{
    private Array<E> data;

    public ArrayStack() {
        this.data = new Array<>();
    }

    public ArrayStack(int capacity) {
        this.data = new Array<>(capacity);
    }

    public void push(E e) {
        data.addLast(e);
    }

    public E pop() {
        return data.removeLast();
    }

    public E peek() {
        return data.getLast();
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder dataStr = new StringBuilder();
        dataStr.append("Stack [");
        for (int i = 0; i < data.getSize(); i++) {
            dataStr.append(data.get(i));
            if (i == data.getSize() - 1) {
                dataStr.append("] top");
            } else {
                dataStr.append(",");
            }
        }
        return String.format("%s",dataStr);
    }

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack=new ArrayStack<>();
        for (int i = 0; i < 10; i++) {
            arrayStack.push(i);
        }
        System.out.println(arrayStack);
        Integer pop = arrayStack.pop();
        System.out.println(pop);
        System.out.println(arrayStack);
        System.out.println(arrayStack.peek());
    }
}
