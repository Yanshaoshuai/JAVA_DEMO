package com.javademo.base.algorithm.leetcode.problems.setandmap;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /03 11:35
 **/
public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> record=new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            record.add(nums1[i]);
        }
        Set<Integer> result=new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if(record.contains(nums2[i])){
                result.add(nums2[i]);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

    }
}
