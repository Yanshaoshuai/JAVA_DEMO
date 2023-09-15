package com.javademo.base.algorithm.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /03 16:02
 **/
public class Solution219 {
    /**
     * time O(n)
     * space O(k)
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < nums.length;i++) {
                if(set.contains(nums[i])){
                    return true;
                }
                set.add(nums[i]);
                if(set.size()>k){
                    set.remove(nums[i-k]);
                }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution219 solution219=new Solution219();
        boolean b = solution219.containsNearbyDuplicate(new int[]{1,0,1,1}, 1);
        System.out.println(b);
    }
}
