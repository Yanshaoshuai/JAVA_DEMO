package com.javademo.base.algorithm.leetcode.problems.dp;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /16 16:06
 **/
public class Lcs {
    /**
     * 最长公共子序列问题
     * Longest Common Sequence
     * 简称LCS问题
     * Lcs(m,n) s1[0...m]和s2[0...n]的最长公共子序列的长度
     * s1[m]==s2[n]
     * Lcs(m,n)=1+Lcs(m-1,n-1)
     * s1[m]!=s2[n]
     * Lcs(m,n)=max(Lcs(m-1,n),Lcs(m,n-1))
     * @param s1
     * @param s2
     * @return
     */
    public int lcs(String s1,String s2){
        //todo
        return 0;
    }
}
