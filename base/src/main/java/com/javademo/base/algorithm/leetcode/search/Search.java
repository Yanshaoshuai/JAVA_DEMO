package com.javademo.base.algorithm.leetcode.search;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /02 14:32
 **/
public class Search {
    /**
     * 二分查找r=n-1
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearch(int[] arr,int target){
        //[l,r]内寻找target
        int l=0,r=arr.length-1;
        while (l<=r){
            int mid=(l+r)/2;
            if(mid==target){
                return mid;
            }
            if(target>arr[mid]){
                l=mid+1;
            }else {
                r=mid-1;
            }
        }
        return -1;
    }

    /**
     * 二分查找r=n
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearch2(int[] arr,int target){
        //[l,r)内寻找target
        int l=0,r=arr.length;
        while (l<r){
            int mid=(l+r)/2;
            if(mid==target){
                return mid;
            }
            if(target>arr[mid]){
                //[l,r)
                l=mid+1;
            }else {
                //[l,r)
                r=mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr=new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i]=i;
        }
        int i = binarySearch(arr, 5);
        System.out.println(arr[i]);
    }
}
