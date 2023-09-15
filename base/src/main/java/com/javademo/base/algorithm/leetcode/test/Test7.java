package com.javademo.base.algorithm.leetcode.test;

import java.util.Scanner;

/**
 * @Author Mr.Yan
 * @Date 2020 / 10 /13 22:21
 **/
public class Test7 {
    public static void main(String[] args) {
        Scanner in = new Scanner( System.in );
        while (in.hasNextLine()) {
            String s = in.nextLine();
            String[] split = s.split("\\.");
            Integer integer=Integer.valueOf(split[0]);
            String str = split[1].substring(0, 1);
            Integer integer1 = Integer.valueOf(str);
            if(integer1>=5){
                integer+=1;
            }
            System.out.println(integer);
        }
    }
}
