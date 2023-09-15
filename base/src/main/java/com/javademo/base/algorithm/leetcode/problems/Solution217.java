package com.javademo.base.algorithm.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /03 16:38
 **/
public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
