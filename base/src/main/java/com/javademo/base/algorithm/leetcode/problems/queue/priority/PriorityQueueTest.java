package com.javademo.base.algorithm.leetcode.problems.queue.priority;

import javax.print.attribute.IntegerSyntax;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /12 16:42
 **/
public class PriorityQueueTest {
    public static void main(String[] args) {
        Random random=new Random();
        //最大堆传入自定义Comparator  默认是最小堆
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < 10; i++) {
            int nextInt = random.nextInt(100);
            priorityQueue.offer(nextInt);
            System.out.println("insert "+nextInt+ " in priority queue.");
        }
        //默认是最小堆
        while (!priorityQueue.isEmpty()){
            System.out.print(priorityQueue.poll()+" ");
        }
    }
}
