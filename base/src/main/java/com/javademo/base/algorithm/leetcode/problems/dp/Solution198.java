package com.javademo.base.algorithm.leetcode.problems.dp;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /14 20:36
 **/
public class Solution198 {
    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int n=nums.length;
        //memo[i]表示考虑抢劫 nums[i...n-1]所能获得的最大收益
        int[] memo=new int[n];
        memo[n-1]=nums[n-1];
        for (int i = n-2; i >=0; i--) {
            for (int j = i; j <n; j++) {
                memo[i]=Integer.max(memo[i],nums[j]+(j+2<n?memo[j+2]:0));
            }
        }
        return memo[0];
    }

    public int robRS(int[] nums) {
        memory=new int[nums.length];
        for (int i = 0; i < memory.length; i++) {
            memory[i]=-1;
        }
        return tryRob(nums,0);
    }

    private int[]memory;
    /**
     * 考虑抢劫 nums[index...nums.size()]这个范围的所有房子
     * @param nums
     * @param index
     * @return
     */
    private int tryRob(int[] nums, int index) {
        if(index>=nums.length){
            return 0;
        }
        if(memory[index]!=-1){
            return memory[index];
        }
        int result=0;
        for (int i = index; i < nums.length; i++) {
            result=Integer.max(result,nums[i]+tryRob(nums,i+2));
        }
        memory[index]=result;
        return result;
    }
}
