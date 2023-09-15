package com.javademo.base.algorithm.leetcode.problems.dp;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /14 15:50
 **/
public class Solution739 {
    /**
     * 超时
     * @param n
     * @return
     */
    public int fib1(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return (fib(n-1)+fib(n-2))%1000000007;
    }

    /**
     * 动态规划
     * 自底向上解决
     * 不会栈溢出
     * 最优解
     * @param n
     * @return
     */
    public int fib3(int n) {
        memory=new int[n+1];
        memory[0]=0;
        memory[1]=1;
        for (int i = 2; i <= n; i++) {
            memory[i]=(memory[i-1]+memory[i-2])%1000000007;
        }
        return memory[n];
    }

    private int [] memory;
    public int fib(int n) {
        memory=new int[n+1];
        int result=fibHelp(n);
        return result;
    }

    /**
     * 使用一个全局数组来保存已经计算过的斐波那契数
     * 记忆化搜索
     * 自顶向下解决
     * @param n
     * @return
     */
    private int  fibHelp(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(memory[n]==0){
            memory[n]=fibHelp(n-1)+fibHelp(n-2);
        }
        return memory[n]%1000000007;
    }

    public static void main(String[] args) {
        Solution739 solution739=new Solution739();
        System.out.println(solution739.fib3(10000000));
    }
}
