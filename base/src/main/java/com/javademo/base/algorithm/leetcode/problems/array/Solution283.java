package com.javademo.base.algorithm.leetcode.problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /02 15:02
 **/
public class Solution283 {
    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 示例:
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     * 时间O(n)
     * 空间O(n)
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        List<Integer> noZeroList=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                noZeroList.add(nums[i]);
            }
        }
        for (int i = 0; i < noZeroList.size(); i++) {
            nums[i]=noZeroList.get(i);
        }
        for (int i = noZeroList.size(); i < nums.length; i++) {
            nums[i]=0;
        }
    }

    /**
     * O(n)时间
     * O(1)空间
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        int k=0;
        for (int i = 0; i < nums.length; i++) {
           if(nums[i]!=0){
            nums[k++]=nums[i];
           }
        }
        for (int i = k; i < nums.length; i++) {
            nums[i]=0;
        }
    }
    public void moveZeroes3(int[] nums) {
        int k=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                int t=nums[k];
                nums[k]=nums[i];
                nums[i]=t;
                k++;
            }
        }
    }
    public void moveZeroes4(int[] nums) {
        int k=0;
        for (int i = 0; i < nums.length; i++) {
           if(nums[i]!=0){
               if(i!=k){
                   int t=nums[k];
                   nums[k]=nums[i];
                   nums[i]=t;
                   k++;
               }else {//避免没有为0的 自己和自己交换
                   k++;
               }

           }
        }
    }

    public static void main(String[] args) {
        int[] arr=new int[]{0,1,2,0,3,0,8,4,0,5};
        Solution283 solution283=new Solution283();
//        solution283.moveZeroes(arr);
//        solution283.moveZeroes2(arr);
        solution283.moveZeroes3(arr);
        System.out.println(Arrays.toString(arr));
    }
}
