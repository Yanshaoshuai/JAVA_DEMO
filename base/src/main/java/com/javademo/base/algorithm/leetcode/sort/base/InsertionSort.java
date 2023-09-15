package com.javademo.base.algorithm.leetcode.sort.base;

import java.util.Arrays;

/**
 * @Author Mr.Yan
 * @Date 2020 / 10 /13 16:09
 * 插入排序
 **/
public class InsertionSort {
    public static void insertionSort(int[] nums){
        for (int i = 1; i < nums.length; i++) {//插入n-1次
            for (int j = i; j >0 ; j--) {//插入到之前有序的合适位置
                if(nums[j]<nums[j-1]){
                    int temp=nums[j];
                    nums[j]=nums[j-1];
                    nums[j-1]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,3,2,8,4,5};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
