package com.javademo.base.algorithm.leetcode.sort.base;

import java.util.Arrays;

/**
 * @Author Mr.Yan
 * @Date 2020 / 10 /13 14:58
 * 冒泡排序
 **/
public class BubbleSort {
    /**
     * 优化:boolean值记录一次外循环中的所有内循环是否没有交换,如果没有交换就已经有序
     * @param nums
     */
    public static void bubbleSort2(int[] nums){
        boolean isSwap=false;
        for (int i = 0; i < nums.length-1; i++) {//n-1次 每次迭代找到最大的放到最后
            for (int j = 0; j <nums.length-i-1; j++) {//每次 n-i次内部循环 j+1<=n-1
                if(nums[j]>nums[j+1]){
                    isSwap=true;
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
            if(isSwap){
                isSwap=false;
            }else {
                break;
            }
        }
    }
    public static void bubbleSort(int[] nums){
        for (int i = 0; i < nums.length-1; i++) {//n-1次 每次迭代找到最大的放到最后
            for (int j = 0; j <nums.length-i-1; j++) {//每次 n-i-1次内部循环 j+1<=n-i
                if(nums[j]>nums[j+1]){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] nums=new int[]{1,3,2,8,4,5};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
