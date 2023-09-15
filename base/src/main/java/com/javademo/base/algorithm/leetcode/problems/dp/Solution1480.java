package com.javademo.base.algorithm.leetcode.problems.dp;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /17 22:29
 **/
public class Solution1480 {
    public int[] runningSum(int[] nums) {
        if(nums==null||nums.length==0){
            return new int[]{0};
        }
        int[] memory=new int[nums.length];
        memory[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            memory[i]=memory[i-1]+nums[i];
        }
        return memory;
    }
}
