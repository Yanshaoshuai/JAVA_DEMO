package com.javademo.base.algorithm.leetcode.problems.queue.priority;

import java.util.*;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /12 16:59
 **/
public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        //统计每个元素出现的频率
        Map<Integer,Integer> record=new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if(record.get(nums[i])==null){
                record.put(nums[i],1);
            }else {
                record.put(nums[i],record.get(nums[i])+1);
            }
        }
        int[] result=new int[k];
        //标准Queue 只能先进先出 不能移除末尾 所以采用最小堆 移除队头元素 维护固定尺寸优先级队列
        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue=new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        });
        for (Map.Entry<Integer,Integer> entry:record.entrySet()) {
            if(priorityQueue.size()==k){
                if(entry.getValue()>priorityQueue.peek().getValue()){
                    priorityQueue.poll();
                }else {
                    continue;
                }
            }
            priorityQueue.offer(entry);
        }
        for (int i = 0; i < k; i++) {
            result[k-i-1]=priorityQueue.poll().getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        Solution347 solution347=new Solution347();
        int[] ints = solution347.topKFrequent(new int[]{1, 2, 3, 4, 5, 1, 3, 2, 4, 4, 5, 5, 6, 5}, 3);
        System.out.println(Arrays.toString(ints));
    }
}
