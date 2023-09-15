package com.javademo.base.algorithm.leetcode.problems.array;

import java.util.Arrays;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /02 16:04
 **/
public class Solution75 {
    /**
     * 计数排序
     * time O(n)
     * space O(1)
     * @param nums
     */
    public void sortColors(int[] nums) {
        int redCount=0;
        int whiteCount=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                redCount++;
            }else if (nums[i]==1){
                whiteCount++;
            }
        }
        for (int i = 0; i < redCount; i++) {
            nums[i]=0;
        }
        for (int i = redCount; i <redCount+whiteCount ; i++) {
            nums[i]=1;
        }
        for (int i = redCount+whiteCount; i < nums.length; i++) {
            nums[i]=2;
        }
    }

    /**
     * 三路快排
     * time O(n)
     * space O(1)
     * @param nums
     */
    public void sortColors2(int[] nums) {
      //nums[0,zero]
      int zero=-1;
      //nums[two,n-1]
      int two=nums.length;
      for (int i=0;i<two;){
          if(nums[i]==1){
              i++;
          }else if(nums[i]==2){
              two--;
              int t=nums[i];
              nums[i]=nums[two];
              nums[two]=t;
          }else {
              zero++;
              int t=nums[i];
              nums[i]=nums[zero];
              nums[zero]=t;
              i++;
          }
      }
    }

    public static void main(String[] args) {
        int[] arr=new int[]{0,1,2,2,1,0,0,1,1,2,2,0,2,1,1,0};
        Solution75 solution75=new Solution75();
//        solution75.sortColors(arr);
        solution75.sortColors2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
