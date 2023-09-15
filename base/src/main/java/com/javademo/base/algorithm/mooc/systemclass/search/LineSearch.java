package com.javademo.base.algorithm.mooc.systemclass.search;

/**
 * @Author Mr.Yan
 * @Date 2021/12/11 19:27
 **/
public class LineSearch {
    public static <E> int search(E[] data,E target){
        for (int i = 0; i < data.length; i++) {
            if(data[i].equals(target)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] data = {24,18,12,9,16,66,32,4};
        int search = LineSearch.search(data, 16);
        System.out.println(search);
    }
}
