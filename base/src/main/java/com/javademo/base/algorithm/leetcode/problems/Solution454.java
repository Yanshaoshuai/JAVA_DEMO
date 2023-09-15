package com.javademo.base.algorithm.leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /03 14:05
 **/
public class Solution454 {
    /**
     * time O(n^2)
     * space O(n^2)
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> cdSumMap=new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum=C[i]+D[j];
                if(cdSumMap.containsKey(sum)){
                    cdSumMap.put(sum,cdSumMap.get(sum)+1);
                }else {
                    cdSumMap.put(sum,1);
                }
            }
        }
        int count=0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int  sum=A[i]+B[j];
                int searchNum=0-sum;
                if(cdSumMap.containsKey(searchNum)){
                    int cdSumCount = cdSumMap.get(searchNum);
                    count+=cdSumCount;
                }
            }
        }
        return count;
    }
}
