package com.javademo.base.algorithm.leetcode.test;

import java.util.Scanner;

/**
 * @Author Mr.Yan
 * @Date 2020 / 10 /13 21:58
 **/
public class Test6 {
    public static void main(String[] args) {
        Scanner in = new Scanner( System.in );
        while (in.hasNextLine()){
            String s = in.nextLine();
            Long aLong = Long.valueOf(s);
            int i=2;
           while (aLong!=1&&i<Math.sqrt(aLong)){
               if(aLong%i==0){
                   aLong=aLong/i;
                   System.out.print(i+" ");
                   i=2;
               }else {
                   i++;
               }
           }
            System.out.print(aLong+" ");
        }
    }
}
