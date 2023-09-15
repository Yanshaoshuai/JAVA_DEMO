package com.javademo.base.algorithm.leetcode.problems.dp;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /16 12:00
 **/
public class Knapsack02 {
    public int knapsack02(int[] w,int[] v, int c){
        int n=w.length;
        if (n==0){
            return 0;
        }
        int [][] memory=new int[n][c+1];
        for (int i = 0; i < memory.length; i++) {
            for (int j = 0; j < memory[i].length; j++) {
                memory[i][j]=-1;
            }
        }
        /**
         * 把第0个物品放入容量为j的背包
         */
        for (int j = 0; j <=c ; j++) {
            memory[0][j]=(j>=w[0]?v[0]:0);
        }
        /**
         * 1...i物品放入容量为j的背包
         */
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <=c; j++) {
                memory[i][j]=memory[i-1][j];
                if(j>=w[i]){
                    //1. 不装第i个物品 重量为 memory[i-1][j]
                    //2. 装第i个物品  重量为 v[i]+memory[i-1][j-w[i]]
                    memory[i][j]=Integer.max(memory[i][j],v[i]+memory[i-1][j-w[i]]);
                }
            }
        }
        return memory[n-1][c];
    }

    /**
     * 优化空间复杂度O(2C)
     * @param w
     * @param v
     * @param c
     * @return
     */
    public int knapsack03(int[] w,int[] v, int c){
        int n=w.length;
        if (n==0){
            return 0;
        }
        int [][] memory=new int[2][c+1];
        for (int i = 0; i < memory.length; i++) {
            for (int j = 0; j < memory[i].length; j++) {
                memory[i][j]=-1;
            }
        }
        /**
         * 把第0个物品放入容量为j的背包
         */
        for (int j = 0; j <=c ; j++) {
            memory[0][j]=(j>=w[0]?v[0]:0);
        }
        /**
         * 1...i物品放入容量为j的背包
         */
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <=c; j++) {
                memory[i%2][j]=memory[(i-1)%2][j];
                if(j>=w[i]){
                    //1. 不装第i个物品 重量为 memory[i-1][j]
                    //2. 装第i个物品  重量为 v[i]+memory[i-1][j-w[i]]
                    memory[i%2][j]=Integer.max(memory[i%2][j],v[i]+memory[(i-1)%2][j-w[i]]);
                }
            }
        }
        return memory[(n-1)%2][c];
    }
    /**
     * 优化空间复杂度O(C)
     * @param w
     * @param v
     * @param c
     * @return
     */
    public int knapsack04(int[] w,int[] v, int c){
        int n=w.length;
        if (n==0){
            return 0;
        }
        int [] memory=new int[c+1];
        for (int i = 0; i < memory.length; i++) {
                memory[i]=-1;
        }
        /**
         * 把第0个物品放入容量为j的背包
         */
        for (int j = 0; j <=c ; j++) {
            memory[j]=(j>=w[0]?v[0]:0);
        }
        /**
         * 1...i物品放入容量为j的背包
         */
        for (int i = 1; i < n; i++) {
            for (int j = c; j >=w[i]; j--) {
                    memory[j]=Integer.max(memory[j],v[i]+memory[j-w[i]]);
            }
        }
        return memory[c];
    }

    public static void main(String[] args) {
        Knapsack02 knapsack02=new Knapsack02();
        int result = knapsack02.knapsack04(new int[]{1, 2, 3}, new int[]{6, 10, 12}, 5);
        System.out.println(result);
    }
}
