package com.javademo.base.algorithm.leetcode.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Mr.Yan
 * @Date 2020 / 10 /13 20:05
 **/
public class Test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner( System.in );
        int n=0;
        List<String> list=new LinkedList<>();
        while (in.hasNextLine()){
            String s = in.nextLine();
            int size=Integer.valueOf(s);
            for (int i = 0; i <size; i++) {
                list.add(in.nextLine());
            }
            in.nextLine();
            if(in.nextLine().equals("")){
                break;
            }
        }
        System.out.println(list);
        list.stream().distinct().mapToInt(s->Integer.valueOf(s)).sorted().forEach(s-> System.out.println(s));
    }
}
