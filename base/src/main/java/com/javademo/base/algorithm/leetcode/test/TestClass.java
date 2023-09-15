package com.javademo.base.algorithm.leetcode.test;

import java.util.Scanner;

/**
 * @Author Mr.Yan
 * @Date 2020 / 10 /13 19:38
 **/
public class TestClass {
    public static void main(String[] args) {
        Scanner in = new Scanner( System.in );
        while (in.hasNextLine()){
            String str=in.nextLine();
            String[] s = str.split(" ");
            System.out.println(s[s.length-1].length());
        }
    }
}
