package com.javademo.base.algorithm.leetcode.problems.dp;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /14 18:14
 **/
public class Solution70 {
    /**
     * 自底向上
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n==0||n==1){
            return 1;
        }
        int[] resultAll=new int[n+1];
        resultAll[0]=1;//到达第0层 1种方法
        resultAll[1]=1;//到达第1层 1种方法
        for (int i = 2; i <= n; i++) {//到达第i层的方法数=到达第i-1层的方法数+到达第i-2层的方法数
            resultAll[i]=resultAll[i-1]+resultAll[i-2];
        }
        return resultAll[n];
    }

    /**
     * 自顶向下
     * 记忆搜索
     */
    private int[] memory;
    public int climbStairsRS(int n) {
       memory=new int[n];
       return climbStairsRSHelp(n);
    }
    private int climbStairsRSHelp(int n) {
        if(n==1||n==0){
            return 1;
        }
        if(memory[n-1]==0){
            int next1=climbStairsRSHelp(n-1);
            int next2=climbStairsRSHelp(n-2);
            memory[n-1]=next1+next2;
        }

        return memory[n-1];
    }

    public static void main(String[] args) {
        Solution70 solution70=new Solution70();
        int climbStairsRS = solution70.climbStairsRS(2);
        System.out.println(climbStairsRS);
        System.out.println(solution70.climbStairs(2));
    }
}
