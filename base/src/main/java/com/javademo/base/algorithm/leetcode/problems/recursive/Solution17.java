package com.javademo.base.algorithm.leetcode.problems.recursive;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /13 17:24
 **/
public class Solution17 {
    private static String[] letterMap=new String[]{
            "",//0
            "",//1
            "abc",//2
            "def",//3
            "ghi",//4
            "jkl",//5
            "mno",//6
            "pqrs",//7
            "tuv",//8
            "wxyz"//9
    } ;
    private List<String> result=new LinkedList<>();
    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0){
            return result;
        }
        findCombination(digits,0,"");
        return result;
    }

    /**
     * s 保存了 digits[0...index-1]翻译得到的一个字母字符串
     *  寻找和digits[index]匹配的字母,获得digits[0...index]翻译得到的解
     * @param digits
     * @param index
     * @param s
     * @return
     */
    private void findCombination(String digits,int index,String s){
        System.out.println(index+":"+s);
        if(digits.length()==index){
            //找到一条路径 保存s
            result.add(s);
            return ;
        }
        char c = digits.charAt(index);//找到第index输入的数字
        String letters=letterMap[c-'0'];//找到数字对应的字母
        for (int i = 0; i <letters.length() ; i++) {//循环递归每个可能的字母和其它字母的组合
            System.out.println("digits["+index+"]="+c+",use->"+letters.charAt(i));
            findCombination(digits,index+1,s+letters.charAt(i));
        }
        System.out.println("digits["+index+"] = "+c+" complete, return");
    }

    public static void main(String[] args) {
        Solution17 solution17=new Solution17();
        List<String> result = solution17.letterCombinations("23456789");
        System.out.println(result);
    }
}
