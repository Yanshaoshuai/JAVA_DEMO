package com.javademo.base.algorithm.leetcode.sort;


import java.util.Arrays;

/**
 * @Author Mr.Yan
 * @Date 2020 / 10 /13 19:19
 **/
public class Solution912_quick {
    public int[] sortArray(int[] nums) {
        sort(nums,0,nums.length-1);
        return nums;
    }

    private void sort(int[] nums, int l, int r) {
        if(l>=r){
            return;
        }
        int j=partition(nums,l,r);//分区 [l,j-1] <=j<= [j+1,r]
        sort(nums,l,j-1);
        sort(nums,j+1,r);
    }

    private int partition(int[] nums, int l, int r) {
        int i=l;
        int j=r+1;
        int indexValue=nums[l];
        while (true){
            while (nums[++i]<indexValue){
                if(i>=r){
                    break;
                }
            }
            while (nums[--j]>indexValue){
                if(j<=l){
                    break;
                }
            }
            if(i>=j){//指针相碰 退出
                break;
            }
            swap(nums,i,j);
        }
        swap(nums,l,j);//交换j指向的位置和index
        return j;
    }

    private void swap(int[] nums, int a, int b) {
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{6,5,4,2,3,1};
        new Solution912_quick().sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }
}
