package com.javademo.base.algorithm.leetcode.problems.array;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /02 17:19
 **/
public class Solution209 {
    /**
     * time O(n)
     * space O(1)
     * 滑动窗口
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int l=0;
        int r=-1;
        int sum=0;
        int width=nums.length+1;
        while (l<nums.length){
            if(r+1<nums.length&&sum<s){
                //右臂向右滑动 增大sum
                sum+=nums[++r];
            }else {
                //左臂向右滑动 减小sum
                sum-=nums[l++];
            }
            if(sum>=s){
                //在符合条件的sum中取最小宽度
                width=Math.min(width,r-l+1);
            }
        }
        if(width==nums.length+1){
            return 0;
        }
        return width;
    }
}
