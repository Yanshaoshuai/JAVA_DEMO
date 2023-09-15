package com.javademo.base.algorithm.leetcode.sort;

/**
 * @Author Mr.Yan
 * @Date 2020 / 10 /13 17:10
 **/
public class Solution912 {
    private static int[] aux;
    public int[] sortArray(int[] nums) {
        aux=new int[nums.length];
        sort(nums,0,nums.length-1);
        return nums;
    }
    private void sort(int[]nums,int l,int r){
        if(l>=r){
            return;
        }
        int mid=(l+r)/2;
        sort(nums,l,mid);
        sort(nums,mid+1,r);
        merge(nums,l,mid,r);
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int i=l;
        int j=mid+1;
        for (int k = l; k <=r; k++) {
            aux[k]=nums[k];
        }
        for (int k = l; k <=r; k++) {
            if(i>mid){
                nums[k]=aux[j++];
            }else if(j>r){
                nums[k]=aux[i++];
            }else if(aux[i]<aux[j]){
                nums[k]=aux[i++];
            }else {
                nums[k]=aux[j++];
            }
        }
    }
}
