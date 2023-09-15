package com.javademo.base.algorithm.leetcode.problems.setandmap;

import java.util.*;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /03 11:46
 **/
public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> retultList=new ArrayList<>();
        Map<Integer,Integer> numberCountMap1=new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if(numberCountMap1.containsKey(nums1[i])){
                numberCountMap1.put(nums1[i],numberCountMap1.get(nums1[i])+1);
            }else {
                numberCountMap1.put(nums1[i],1);
            }
        }
        for (int i = 0; i <nums2.length; i++) {
            if(numberCountMap1.containsKey(nums2[i])&&numberCountMap1.get(nums2[i])!=null&&numberCountMap1.get(nums2[i])>0){
                numberCountMap1.put(nums2[i],numberCountMap1.get(nums2[i])-1);
                retultList.add(nums2[i]);
            }
        }
        return retultList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution350 solution350=new Solution350();
        int[] intersect = solution350.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        System.out.println(Arrays.toString(intersect));

    }
}
