package com.javademo.base.algorithm.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /03 13:40
 **/
public class Solution1 {
    /**
     * 查找表
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
       Map<Integer,Integer> record=new HashMap();
        for (int i = 0; i < nums.length; i++) {
            record.put(nums[i],i);
        }
        //time O(n)
        for (int i = 0; i < nums.length; i++) {
            int searchNum=target-nums[i];
            if(record.containsKey(searchNum)&&record.get(searchNum)!=null&&record.get(searchNum)!=i){
                return new int[]{i,record.get(searchNum)};
            }
        }
        return null;
    }
    public int[] twoSum2(int[] nums, int target) {
       Map<Integer,Integer> record=new HashMap();
        //time O(n)
        for (int i = 0; i < nums.length; i++) {
            int searchNum=target-nums[i];
            if(record.containsKey(searchNum)&&record.get(searchNum)!=null&&record.get(searchNum)!=i){
                return new int[]{i,record.get(searchNum)};
            }
            record.put(nums[i],i);
        }
        return null;
    }
}
