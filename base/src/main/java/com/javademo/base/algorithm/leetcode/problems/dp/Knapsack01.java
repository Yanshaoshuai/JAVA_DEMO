package com.javademo.base.algorithm.leetcode.problems.dp;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /16 11:42
 **/
public class Knapsack01 {
    private int [][]memory;
    /**
     * 0-1背包问题
     * w.length=v.length
     * @param w 物品所占容积
     * @param v 物品价值
     * @param c 总容积
     * @return
     */
    public int knapsack01(int[] w,int v[],int c){
        int n=w.length;
        memory=new int[n][c+1];
        for (int i = 0; i < memory.length; i++) {
            for (int j = 0; j < memory[i].length; j++) {
                memory[i][j]=-1;
            }
        }
        return bestValue(w,v,n-1,c);
    }

    /**
     * 用 [0...index]的物品,填充容积为c的背包的最大值
     * @param w
     * @param v
     * @param index
     * @param c
     * @return
     */
    private int bestValue(int[] w, int[] v, int index, int c) {
        if(index<0||c<=0){//index小于0或者背包容积<=0返回0
            return 0;
        }
        if(memory[index][c]!=-1){
            return memory[index][c];
        }
        //第index个不放入背包
        int result=bestValue(w,v,index-1,c);
        //第index个放入背包
        if(c>=w[index]){
            result=Integer.max(v[index]+bestValue(w,v,index-1,c-w[index]),result);
        }
        memory[index][c]=result;
        return result;
    }
    public static void main(String[] args) {
        Knapsack01 knapsack01=new Knapsack01();
        int result = knapsack01.knapsack01(new int[]{1, 2, 3}, new int[]{6, 10, 12}, 5);
        System.out.println(result);
    }
}
