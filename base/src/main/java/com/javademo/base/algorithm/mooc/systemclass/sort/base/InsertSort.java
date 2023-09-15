package com.javademo.base.algorithm.mooc.systemclass.sort.base;


import com.javademo.base.algorithm.utils.ArrayGenerator;
import com.javademo.base.algorithm.utils.SortingHelper;

/**
 * @Author Mr.Yan
 * @Date 2021/12/18 15:58
 * 时间复杂度O(n^2)
 * 插入排序对于有序数组时间复杂度是O(n)
 **/
public class InsertSort {
    public static void sort(Integer[] a){
        for (int i = 0; i < a.length; i++) {
            int j = i;
            for (; j -1 >=0&&a[j-1]>a[i]; j--) {
                    a[j]=a[j-1];
            }
            a[j]=a[i];
        }
    }

    public static void main(String[] args) {
        Integer[] integers = ArrayGenerator.generateRandomArray(100000, 100000);
        sort(integers);
        boolean sorted = SortingHelper.isSorted(integers);
        System.out.println(sorted);
    }
}
