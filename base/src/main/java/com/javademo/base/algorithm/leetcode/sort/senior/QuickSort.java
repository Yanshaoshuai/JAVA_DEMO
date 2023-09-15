package com.javademo.base.algorithm.leetcode.sort.senior;

import java.util.Arrays;

/**
 * @Author Mr.Yan
 * @Date 2020 / 10 /13 18:14
 **/
public class QuickSort {
    public  void quickSort(int[] nums){
        sort(nums,0,nums.length-1);
    }

    private  void sort(int[] nums, int l, int r) {
        if(r<=l){
            return;
        }
        int j=partition(nums,l,r);//分区 [l,j-1]<=j<=[j+1,r] 有序
        sort(nums,l,j-1);//对左边递归
        sort(nums,j+1,r);//对右边递归
    }

    private  int partition(int[] nums, int l, int r) {
        int i=l,j=r+1;
        int indexValue=nums[l];//轴点
        while (true){
            while (nums[++i]<indexValue){//找到左边大于于轴点的值
                if(i==r){
                    break;
                }
            }
            while (nums[--j]>indexValue){//找到右边小于轴点的值
                if(j==l){
                    break;
                }
            }
            if(i>=j){
                break;
            }
         swap(nums,i,j);//交换左右
        }
        swap(nums,l,j);//把轴点值放入正确位置
        return j;
    }
    public void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{6,5,4,2,3,1};
        new QuickSort().quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
