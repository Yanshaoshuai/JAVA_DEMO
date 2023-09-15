package com.javademo.base.algorithm.leetcode.problems.dp;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /14 18:57
 **/
public class Solution343 {
    /**
     * 动态规划
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if(n<2){
            return 1;
        }
       int[] memory=new int[n+1];

       memory[1]=1;
        for (int i = 2; i <=n ; i++) {
            //求解 memory[i]
            for (int j = 1; j <= i-1; j++) {
                //求 j*(i-j) j*memory[i-j] memory[i]中最大的 赋给memory[i]
                //j (i-j)
                int max=Integer.max(j*(i-j),j*memory[i-j]);
                memory[i]=Integer.max(max,memory[i]);
            }
        }
        return memory[n];
    }
    /**
     * 最优子结构
     * @param n
     * @return
     */
    public int integerBreakRS(int n) {
        memory=new int[n+1];//保存每个n的最大乘积
        return breakInteger(n);
    }

    /**
     * 将n进行分割 且至少分割成两部分 求各部分相乘的最大乘积
     * @param n
     * @return
     */
    private int[] memory;
    private int breakInteger(int n) {
        if(n==1){
            return 1;
        }
        int result=0;
        if(memory[n]!=0){
            return memory[n];//记忆每个数的最大拆分乘积
        }
        for (int i = 1; i <=n-1 ; i++) {
            // i - (n-i)
            int max=Integer.max(i*(n-i),i * breakInteger(n - i));
            result=Integer.max(max,result);
        }
        memory[n]=result;
        return result;
    }
}
