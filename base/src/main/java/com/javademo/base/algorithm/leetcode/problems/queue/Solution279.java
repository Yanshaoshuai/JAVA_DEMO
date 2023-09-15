package com.javademo.base.algorithm.leetcode.problems.queue;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /12 15:36
 **/
public class Solution279 {
    public int numSquares(int n) {
        LinkedList<Pair> queue=new LinkedList<>();
        Map<Integer,Boolean> flagMap=new HashMap<>();
        queue.offer(new Pair(n,0));
        flagMap.put(n,true);
        while (!queue.isEmpty()){
            Pair front = queue.poll();
            Integer num = front.num;
            Integer step = front.step;
          /*  if(num==0){
                return step;
            }*/
            for (int i = 1;; i++) {
                int next=num - i * i;
                if(next<0){
                    break;
                }
                if(next==0){
                    return step+1;
                }
                //每个num都要和相距i^2的点相连
                if(flagMap.get(next)==null||!flagMap.get(next)){
                    //去除冗余节点
                    queue.offer(new Pair(next,step+1));
                    flagMap.put(next,true);
                }
            }
        }
        return 0;
    }
    class Pair{
        private Integer num;
        private Integer step;

        public Pair(Integer num, Integer step) {
            this.num = num;
            this.step = step;
        }
    }
    public static void main(String[] args) {
        Solution279 solution279=new Solution279();
        int numSquares = solution279.numSquares(12);
        System.out.println(numSquares);
    }
}

