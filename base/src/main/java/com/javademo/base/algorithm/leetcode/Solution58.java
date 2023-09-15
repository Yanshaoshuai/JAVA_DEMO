package com.javademo.base.algorithm.leetcode;

/**
 * @Author Mr.Yan
 * @Date 2020 / 10 /11 21:18
 **/
public class Solution58 {
    public int maxProfit(int[] prices) {
      if(prices==null||prices.length==0){
          return 0;
      }
      int max=0;
      int minPrice=prices[0];
        for (int i = 0; i < prices.length; i++) {
            //找到已遍历的最小值
           minPrice=Integer.min(prices[i],minPrice);
           //把当前值减去已遍历的最小值就是今天的最大收益
           max=Integer.max(max,prices[i]-minPrice);
        }
        return max;
    }
}
