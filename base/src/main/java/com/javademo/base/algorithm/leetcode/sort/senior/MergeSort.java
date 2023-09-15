package com.javademo.base.algorithm.leetcode.sort.senior;

import java.util.Arrays;

/**
 * @Author Mr.Yan
 * @Date 2020 / 10 /13 16:34
 **/
public class MergeSort {
    private static int[]aux;
    public static void mergeSort(int[] nums){
        aux=new int[nums.length];
        sort(nums,0,nums.length-1);
    }
    private static void sort(int[] nums, int l, int r) {
        if(r<=l){
            return;
        }
        int mid=(l+r)/2;
        sort(nums,l,mid);//将左半边排序
        sort(nums,mid+1,r);//将右半边排序
        merge(nums,l,mid,r);//左右归并
    }

    /**
     * 和并有序数组[l,mid],[mid+1,r]=>[l,r]
     * @param nums
     * @param l
     * @param mid
     * @param r
     */
    private static void merge(int[] nums, int l, int mid, int r) {
        int  i=l,j=mid+1;
        for (int k = l; k <=r; k++) {//复制[l,r]
            aux[k]=nums[k];
        }
        for (int k = l; k <=r ; k++) {
            if(i>mid){//左边已经用完,剩下都用右边
                nums[k]=aux[j++];
            }else if(j>r){//右边已经用完,剩下都用左边
               nums[k]=aux[i++];
            }else if(aux[j]<aux[i]){//左右都没用完 比较大小判断用哪个
                nums[k]=aux[j++];
            }else {
                nums[k]=aux[i++];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,3,2,8,4,5};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
