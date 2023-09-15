package com.javademo.base.algorithm.leetcode.sort.practice;

import java.util.Arrays;

/**
 * @Author Mr.Yan
 * @Date 2020 / 10 /15 14:10
 **/
public class QuickSort {
    public void quickSort(int[] nums){
        sort(nums,0,nums.length-1);
    }

    private void sort(int[] nums, int l, int r) {
        if(l>r){
            return;
        }
        int j=partition(nums,l,r);//[l,j] j [j,r]
        sort(nums,l,j-1);
        sort(nums,j+1,r);
    }

    private int partition(int[] nums, int l, int r) {
        int indexValue=nums[l];
        int i=l,j=r+1;
        while (true){
            while (nums[++i]<indexValue){
                if(i==r){
                    break;
                }
            }
            while (nums[--j]>indexValue){
                if(j==l){
                    break;
                }
            }
            if(i>=j){
                break;
            }
            swap(nums,i,j);
        }
        swap(nums,l,j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{6,5,4,2,3,1};
        new QuickSort().quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
