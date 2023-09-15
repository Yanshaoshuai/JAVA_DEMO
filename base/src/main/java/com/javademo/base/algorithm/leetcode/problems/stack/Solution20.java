package com.javademo.base.algorithm.leetcode.problems.stack;

import java.util.LinkedList;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /11 18:55
 **/
public class Solution20 {
    public boolean isValid(String s) {
        LinkedList<Character> stack=new LinkedList();
        for (int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }else {
                if(stack.size()==0){
                    return false;
                }
                Character c = stack.peek();
                stack.pop();
                char match=' ';
                //获取和当前符号匹配的符号
                switch (s.charAt(i)){
                    case ')':
                        match='(';
                        break;
                    case ']':
                        match='[';
                        break;
                    case '}':
                        match='{';
                        break;
                }
                if (c!=match){
                    //判断栈顶符号是否和当前符号的匹配符号相等
                    return false;
                }
            }
        }
        if (stack.size()!=0){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str="{{([()])}}";
        Solution20 solution20=new Solution20();
        boolean valid = solution20.isValid(str);
        System.out.println(valid);
    }
}
