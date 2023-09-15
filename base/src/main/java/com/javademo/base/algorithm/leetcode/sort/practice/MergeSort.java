package com.javademo.base.algorithm.leetcode.sort.practice;

import java.util.Arrays;

/**
 * @Author Mr.Yan
 * @Date 2020 / 10 /15 18:59
 **/
public class MergeSort {
    private int[] aux;
    public void mergeSort(int[] nums){
        aux=new int[nums.length];
        sort(nums,0,nums.length-1);
    }

    private void sort(int[] nums, int l, int r) {
        if(l>=r){
            return;
        }
        int mid=(l+r)/2;
        sort(nums,l,mid);
        sort(nums,mid+1,r);
        merge(nums,l,mid,r);
    }

    private void merge(int[] nums, int l, int mid, int r) {
        for (int k = l; k <=r; k++) {
            aux[k]=nums[k];
        }
        int i=l,j=mid+1;
        for (int k = l; k <=r; k++) {
            {
                if(i>mid){
                    nums[k]=aux[j++];
                }else if(j>r) {
                    nums[k]=aux[i++];
                }else if(aux[i]<aux[j]){
                    nums[k]=aux[i++];
                }else {
                    nums[k]=aux[j++];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums=new int[]{6,5,4,2,3,1};
        new MergeSort().mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
