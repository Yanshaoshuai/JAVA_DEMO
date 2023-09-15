package com.javademo.base.algorithm.leetcode.problems;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /03 16:43
 **/
public class Solution220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set=new TreeSet<>();
        for (int i = 0; i < nums.length;i++) {
            Integer ceiling = set.ceiling(nums[i]-t);
            if(ceiling!=null&&ceiling<=nums[i]+t){
                return true;
            }
            set.add(nums[i]);
            if(set.size()>k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        TreeSet<Long> set=new TreeSet<>();
        for (int i = 0; i < nums.length;i++) {
            //大于num[i]-t的最小数
            Long ceiling = set.ceiling((long)nums[i]-(long)t);
            if(ceiling!=null&&ceiling<=nums[i]+(long)t){
                return true;
            }
            set.add((long)nums[i]);
            if(set.size()>k){
                set.remove((long)nums[i-k]);
            }
        }
        return false;
    }

}
