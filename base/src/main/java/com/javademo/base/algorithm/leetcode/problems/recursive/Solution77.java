package com.javademo.base.algorithm.leetcode.problems.recursive;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /13 20:50
 **/
public class Solution77 {
    private List<List<Integer>> result=new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        if(n<=0||k<=0||k>n){
            return result;
        }
        //从1开始
        generateCombinations(n,k,1,new LinkedList<>());
        return result;
    }

    /**
     * C(n,k)
     * @param n
     * @param k
     * @param start
     * @param c 当前已经找到的组合存储在C中,需要从start开始搜索新的元素
     */
    private void generateCombinations(int n,int k,int start,LinkedList<Integer> c){
        if(c.size()==k){//找到一个组合 保存并返回
            result.add(new LinkedList<>(c));
            return;
        }
      /*  for (int i = start; i <=n; i++) {
            c.add(i);//i以前的数字已经尝试过了 组合不区分顺序
            generateCombinations(n,k,i+1,c);
            c.removeLast();
        }*/

        /**
         * 剪枝
         * 还有k-c.size()个空位 所以 [i...n] 中至少有k-c.size()个元素
         * i最多为 n-(k-c.size())+1
         */
        for (int i = start; i <=n-(k-c.size())+1; i++) {
            c.add(i);//i以前的数字已经尝试过了 组合不区分顺序
            generateCombinations(n,k,i+1,c);
            c.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution77 solution77=new Solution77();
        List<List<Integer>> combine = solution77.combine(3, 2);
        System.out.println(combine);
    }
}
