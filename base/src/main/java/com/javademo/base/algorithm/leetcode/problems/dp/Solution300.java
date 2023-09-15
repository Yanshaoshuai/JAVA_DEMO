package com.javademo.base.algorithm.leetcode.problems.dp;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /16 15:45
 **/
public class Solution300 {
    /**
     * 最长上升子序列问题
     * Longest Increasing Subsequence
     * 简称为LIS问题
     * LIS(i)=max(1+LIS(j) if nums[i]>nums[j])
     *        j<i
     * Time O(n^2)
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        //memory[i]表示以nums[i]为结尾的最长上升子序列的长度
        int[] memory=new int[nums.length];
        for (int i = 0; i < memory.length; i++) {
            memory[i]=1;
        }
        for (int i = 1; i <nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i]){
                    memory[i]=Integer.max(memory[i],1+memory[j]);
                }
            }

        }
        int result=1;
        for (int i = 0; i < memory.length; i++) {
            result=Integer.max(result,memory[i]);
        }
        return result;
    }
}
