package com.javademo.base.algorithm.leetcode.problems.recursive;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /13 19:58
 **/
public class Solution46 {
    private List<List<Integer>> result=new LinkedList<>();
    private boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        if(nums==null||nums.length==0){
            return null;
        }
        used=new boolean[nums.length];
        generatePermutation(nums,0,new LinkedList<>());
        return result;
    }

    /**
     *
     * @param nums
     * @param index 向p加入第index+1个元素,获得一个有index+1个元素的排列
     * @param p 保存了一个有index个元素的排列
     */
    private void generatePermutation(int[] nums,int index,LinkedList<Integer> p){
        if(index==nums.length){//得到一个长度为nums.length的排列 保存并返回
            result.add(new LinkedList<>(p));
            return;
        }
        for (int i = 0; i <nums.length; i++) {
            if(!used[i]){
                p.add(nums[i]);
                used[i]=true;//往下递归时此元素不再使用
                generatePermutation(nums,index+1,p);
                //递归完之后该元素可用
                p.removeLast();
                used[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        Solution46 solution46=new Solution46();
        List<List<Integer>> permute = solution46.permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }
}
