package com.javademo.base.algorithm.utils;

import java.util.Random;

/**
 * @Author Mr.Yan
 * @Date 2021/12/13 16:28
 **/
public class ArrayGenerator {
    private ArrayGenerator(){};
    public static Integer[] generateOrderedArray(int n){
        Integer[] arr=new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i]=i;
        }
        return arr;
    }
    public static Integer[] generateRandomArray(int n,int bound){
        Integer[] arr=new Integer[n];
        Random random=new Random();
        for (int i = 0; i < n; i++) {
            arr[i]=random.nextInt(bound);
        }
        return arr;
    }
}
