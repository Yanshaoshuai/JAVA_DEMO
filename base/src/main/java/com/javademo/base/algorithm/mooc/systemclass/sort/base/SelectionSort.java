package com.javademo.base.algorithm.mooc.systemclass.sort.base;


import com.javademo.base.algorithm.utils.ArrayGenerator;
import com.javademo.base.algorithm.utils.SortingHelper;

import java.util.Arrays;

/**
 * @Author Mr.Yan
 * @Date 2021/12/13 15:43
 * 时间复杂度O(n^2)
 **/
public class SelectionSort {
    public static void sort(Integer[] a){
        for (int i = 0; i < a.length-1; i++) {
            //[0,i-1]有序
            //选择a[i,n-1]中最小值的索引
            int minIndex=i;
            for (int k = i; k < a.length; k++) {
                if(a[k]<a[minIndex]){
                    minIndex=k;
                }
            }
            //把a[i,n-1]中最小值和a[i]交换
            int temp=a[i];
            a[i]=a[minIndex];
            a[minIndex]=temp;
            //a[0,i]有序 i++
        }
    }

    public static void main(String[] args) {
        Integer [] a= ArrayGenerator.generateRandomArray(10000,10000);
        sort(a);
        System.out.println(Arrays.deepToString(a));
        System.out.println(SortingHelper.isSorted(a));
    }
}
