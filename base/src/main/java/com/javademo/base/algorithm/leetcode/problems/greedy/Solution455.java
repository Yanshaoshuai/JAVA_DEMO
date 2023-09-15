package com.javademo.base.algorithm.leetcode.problems.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /16 17:46
 **/
public class Solution455 {
    /**
     * 贪心算法
     * time O(nlogn)
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren1(int[] g, int[] s) {
        Comparator grater = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
        Integer[] g1 = Arrays.stream(g).boxed().toArray(Integer[]::new);
        Integer[] s1 = Arrays.stream(s).boxed().toArray(Integer[]::new);
        Arrays.<Integer>sort(g1,grater);
        Arrays.<Integer>sort(s1,grater);
        int sp=0;
        int gp=0;
        int result=0;
       while (gp<g1.length&&sp<s1.length){
           if(s1[sp]>=g1[gp]){
               result++;
               sp++;
               gp++;
           }else {
               gp++;
           }
       }
       return result;
    }
    //贪心的思想是，用尽量小的饼干去满足小需求的孩子，所以需要进行排序先
    public int findContentChildren(int[] g, int[] s) {
        int child = 0;
        int cookie = 0;
        Arrays.sort(g);  //先将饼干 和 孩子所需大小都进行排序
        Arrays.sort(s);
        while (child < g.length && cookie < s.length ){ //当其中一个遍历就结束
            if (g[child] <= s[cookie]){ //当用当前饼干可以满足当前孩子的需求，可以满足的孩子数量+1
                child++;
            }
            cookie++; // 饼干只可以用一次，因为饼干如果小的话，就是无法满足被抛弃，满足的话就是被用了
        }
        return child;
    }
}
