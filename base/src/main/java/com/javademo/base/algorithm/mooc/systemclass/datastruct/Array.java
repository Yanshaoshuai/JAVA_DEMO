package com.javademo.base.algorithm.mooc.systemclass.datastruct;

/**
 * @Author Mr.Yan
 * @Date 2021/12/18 17:13
 **/
public class Array<E> {
    private int size;
    private E[] data;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed : index out of bound");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed : index out of bound");
        }
        return data[index];
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public E set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed : index out of bound");
        }
        return data[index] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed : index out of bound");
        }
        E result = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        //lazy resize 防止复杂度震荡
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return result;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeIfExist(E e) {
        int i = find(e);
        if (i != -1) {
            remove(i);
        }
    }

    @Override
    public String toString() {
        StringBuilder dataStr = new StringBuilder();
        dataStr.append("[");
        for (int i = 0; i < size; i++) {
            dataStr.append(data[i]);
            if (i == size - 1) {
                dataStr.append("]");
            } else {
                dataStr.append(",");
            }
        }
        return String.format("Array: size=%d , capacity=%d\ndata=%s", size, data.length, dataStr);
    }

    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);
        array.add(10, 10);
        System.out.println(array);
        array.add(0, -1);
        System.out.println(array);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        array.remove(0);
        System.out.println(array);
        array.remove(9);
        System.out.println(array);
    }
}
