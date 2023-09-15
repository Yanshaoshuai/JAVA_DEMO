package com.javademo.base.algorithm.leetcode.problems.array;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /02 17:38
 **/
public class Solution3 {
    /**
     *  滑动窗口
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int [] freq=new int[256];
        if(s.equals("")){
            return 0;
        }
        char[] chars=s.toCharArray();
        int l=0,r=-1,width=1;
        while (r<chars.length-1){
            if(freq[chars[r+1]]==0){
                freq[chars[++r]]++;
            }else {
                freq[chars[l++]]--;
            }
            width=Math.max(width,r-l+1);
        }
        return width;
    }

    public int lengthOfLongestSubstring2(String s) {
        if(s.equals("")){
            return 0;
        }
        char[] chars=s.toCharArray();
        int l=0,r=0,width=1;
        while (r<chars.length-1){
            r++;
            int repeatIndex=repeatIndex(l,r,chars);
            if (repeatIndex==-1){
                width=Math.max(width,r-l+1);
            } else {
                l=repeatIndex+1;
            }

        }
        return width;
    }

    private int repeatIndex(int l, int r, char[] chars) {
        for (int i = l; i <r; i++) {
            if(chars[r]==chars[i]){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution3 solution3=new Solution3();
        int width = solution3.lengthOfLongestSubstring("aaabcdddclmnpqqqq");
        System.out.println(width);
    }
}
