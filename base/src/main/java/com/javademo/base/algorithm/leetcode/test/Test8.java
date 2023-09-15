package com.javademo.base.algorithm.leetcode.test;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Author Mr.Yan
 * @Date 2020 / 10 /13 22:32
 **/
public class Test8 {
    public static void main(String[] args) {
        Scanner in = new Scanner( System.in );
        while (in.hasNextLine()) {
            String s = in.nextLine();
            Integer size=Integer.valueOf(s);
            TreeMap<Integer,Integer> map=new TreeMap<>();
            for (int i = 0; i < size; i++) {
                int key = in.nextInt();
                int value=in.nextInt();
                if(map.containsKey(key)){
                    map.put(key,map.get(key)+value);
                }else {
                    map.put(key,value);
                }
            }
            map.forEach((k,v)->{
                System.out.println(k+" "+v);
            });
            in.nextLine();
        }
    }
}
