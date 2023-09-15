package com.javademo.base.algorithm.leetcode.problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /03 14:33
 **/
public class Solution447 {
    /**
     * time O(n^2)
     * space O(n)
     * @param points
     * @return
     */
    public int numberOfBoomerangs(int[][] points) {
        int count=0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer,Integer> distanceCountMap=new HashMap<>();
            for (int j = 0; j < points.length; j++) {
               if(i!=j){
                   int distance = distance(points[i][0], points[i][1], points[j][0], points[j][1]);
                   if(distanceCountMap.containsKey(distance)){
                       distanceCountMap.put(distance,distanceCountMap.get(distance)+1);
                   }else {
                       distanceCountMap.put(distance,1);
                   }
               }
            }
            for (Map.Entry<Integer,Integer> entry:distanceCountMap.entrySet()) {
              if(entry.getValue()>=2){
                  count+=entry.getValue()*(entry.getValue()-1);
              }
            }
        }
        return count;
    }
    private int  distance(int x1,int y1,int x2, int y2){
        return (int)(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
    }

    public static void main(String[] args) {
        Solution447 solution447=new Solution447();
        solution447.numberOfBoomerangs(new int[][]{{0,0},{1,0},{2,0}});
    }
}
