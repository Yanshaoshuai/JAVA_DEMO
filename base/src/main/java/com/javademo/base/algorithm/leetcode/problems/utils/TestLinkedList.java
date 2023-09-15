package com.javademo.base.algorithm.leetcode.problems.utils;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /12 14:49
 **/
public class TestLinkedList {
    public static void main(String[] args) {
        //栈测试
        LinkedList<Integer> stack=new LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);//[3, 2, 1]
        System.out.println(stack.pop());//3
        System.out.println(stack);//[2, 1]
        System.out.println(stack.peek());//2
        System.out.println(stack);//[2, 1]
        //队列测试
        LinkedList<Integer> queue=new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue);//[1, 2, 3]
        System.out.println(queue.poll());//1
        System.out.println(queue);//[2, 3]
        System.out.println(queue.peek());//2
        System.out.println(queue);//[2, 3]

        List<Integer> list=new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
    }
}
