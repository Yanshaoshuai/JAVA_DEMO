package com.javademo.base.algorithm.leetcode.test;

import java.util.Scanner;

/**
 * @Author Mr.Yan
 * @Date 2020 / 10 /13 19:46
 **/
public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner( System.in );
        String a=null;
        String b=null;
        while (in.hasNext()){
            a=in.nextLine();
            b=in.nextLine();
            int num=0;
            for (int i = 0; i < a.length(); i++) {
                if((a.charAt(i)+"").equalsIgnoreCase(b)){
                    num++;
                }
            }
            System.out.println(num);
        }

    }
}
