package com.javademo.base.algorithm.leetcode.test;

import java.util.Scanner;

/**
 * @Author Mr.Yan
 * @Date 2020 / 10 /13 21:35
 **/
public class Test4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            int i=s.length()/8;
            int j=s.length()-i*8;
            for (int k = 0; k < i; k++) {
                String temp=s.substring(0,8);
                if(s.length()>=8){
                    s=s.substring(8);
                }
                System.out.println(temp);
            }
            if(j==0){
                continue;
            }
            for (int k = 0; k < 8-j; k++) {
                s+="0";
            }
            System.out.println(s);
        }
    }
}
