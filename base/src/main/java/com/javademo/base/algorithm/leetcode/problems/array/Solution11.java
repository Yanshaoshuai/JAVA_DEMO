package com.javademo.base.algorithm.leetcode.problems.array;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /02 17:11
 **/

public class Solution11 {
    /**
     * 碰撞指针求所有面积中最大的
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int  area=0;
        for (int i = 0,j=height.length-1; i <j;) {
            int h=Math.min(height[i],height[j]);
            area=Math.max(area,h*(j-i));
            if(height[i]<height[j]){
                i++;
            }else {
                j--;
            }
        }
        return area;
    }

    public static void main(String[] args) {

    }
}
