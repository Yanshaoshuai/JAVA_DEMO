package com.javademo.base.algorithm.leetcode.sort.base;

import java.util.Arrays;

/**
 * @Author Mr.Yan
 * @Date 2020 / 10 /13 15:25
 * 选择排序
 **/
public class SelectionSort {
    public static void selectionSort(int[]nums){
        for (int i = 0; i < nums.length-1; i++) {//n-1次选择
            int maxIndex=0;
            for (int j = 1; j <nums.length-i; j++) {//j<n-i
              if(nums[maxIndex]<=nums[j]){//加等号为了稳定
                  maxIndex=j;
              }
            }
            int temp=nums[maxIndex];
            nums[maxIndex]=nums[nums.length-1-i];
            nums[nums.length-1-i]=temp;
        }
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,3,2,8,4,5};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
