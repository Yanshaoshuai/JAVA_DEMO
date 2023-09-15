package com.javademo.base.algorithm.leetcode.problems.array;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /02 16:54
 **/
public class Solution344 {
    /**
     * 对撞指针
     * @param s
     */
    public void reverseString(char[] s) {
        for (int i=0,j=s.length-1;i<j;i++,j--){
            char t=s[i];
            s[i]=s[j];
            s[j]=t;
        }
    }

    public static void main(String[] args) {
        char[] s="fjajgkfljaklgj".toCharArray();
        Solution344 solution344=new Solution344();
        solution344.reverseString(s);
        System.out.println(s);
    }
}
