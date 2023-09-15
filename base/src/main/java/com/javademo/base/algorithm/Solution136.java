package com.javademo.base.algorithm;

/**
 * @Author Mr.Yan
 * @Date 2020 / 10 /11 21:39
 **/
public class Solution136 {
    public int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0]=nums[0]^nums[i];
        }
        return nums[0];
    }
}
