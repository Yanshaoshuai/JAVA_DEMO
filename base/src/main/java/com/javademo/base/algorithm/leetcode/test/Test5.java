package com.javademo.base.algorithm.leetcode.test;

import java.util.Scanner;

/**
 * @Author Mr.Yan
 * @Date 2020 / 10 /13 21:48
 **/
public class Test5 {
    public static void main(String[] args) {
        Scanner in = new Scanner( System.in );
        while (in.hasNextLine()){
            String s = in.nextLine();
            s=s.substring(2);
            Integer integer = Integer.valueOf(s, 16);
            System.out.println(integer);
        }
    }
}
