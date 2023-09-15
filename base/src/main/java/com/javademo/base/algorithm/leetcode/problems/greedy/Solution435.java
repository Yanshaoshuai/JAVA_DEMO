package com.javademo.base.algorithm.leetcode.problems.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /16 18:16
 **/
public class Solution435 {
    /**
     * 动态规划算法
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervalsDP(int[][] intervals) {
        if(intervals.length==0){
            return 0;
        }
        /**
         * 对intervals排序
         */
        Comparator<int[]> lessThan = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[0]==o1[0]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        };
        Arrays.sort(intervals,lessThan);
        int[] memory=new int[intervals.length];
        for (int i = 0; i < memory.length; i++) {
            memory[i]=1;
        }
        //memory[i]表示使用intervals[0...i]的区间能构成的最长不重叠区间序列
        for (int i = 1; i < intervals.length; i++) {
            for (int j = 0; j < i; j++) {
                if(intervals[i][0]>=intervals[j][1]){//左边区间的右界小于等于右边区间的左界
                    //取最大能构成不重叠子区间的长度为memory[i]
                    memory[i]=Integer.max(memory[i],1+memory[j]);
                }
            }
        }
        int result=0;
        for (int i = 0; i < memory.length; i++) {
            result=Integer.max(result,memory[i]);
        }
        return intervals.length-result;
    }

    /**
     * 贪心算法
     * 思想: 把区间靠前且end小的排在前面 给后面留出更大的空间
     * 每次选择结尾最早的,且和前一个区间不重叠的区间
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0){
            return 0;
        }
        /**
         * 对intervals排序
         */
        Comparator<int[]> lessThan = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1]!=o2[1]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        };
        Arrays.sort(intervals,lessThan);
        int result=1;//不重合区间值
        int pre=0;//前一个区间的指针
        for (int i = 0; i < intervals.length; i++) {
            if(intervals[i][0]>=intervals[pre][1]){
                result++;
                pre=i;
            }
        }
        return intervals.length-result;
    }

    public static void main(String[] args) {
        int[][]intervals=new int[][]{{1,2},{2,3},{4,5},{3,4}};
        Comparator<int[]> lessThan = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[0]==o1[0]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        };
        System.out.println(Arrays.deepToString(intervals));
        Arrays.sort(intervals,lessThan);
        System.out.println(Arrays.deepToString(intervals));
    }
}
