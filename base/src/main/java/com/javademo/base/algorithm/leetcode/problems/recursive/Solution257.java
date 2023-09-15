package com.javademo.base.algorithm.leetcode.problems.recursive;


import com.javademo.base.algorithm.leetcode.problems.utils.TreeNode;
import com.javademo.base.algorithm.leetcode.problems.utils.TreeNodeUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /13 12:39
 **/
public class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result=new LinkedList<>();
        if(root==null){
            return result;
        }
        if(root.left==null&&root.right==null){
            result.add(String.valueOf(root.val));
            return result;
        }

        List<String> leftResult = binaryTreePaths(root.left);
        for (int i = 0; i < leftResult.size(); i++) {
            result.add(root.val+"->"+leftResult.get(i));
        }
        List<String> rightResult = binaryTreePaths(root.right);
        for (int i = 0; i < rightResult.size(); i++) {
            result.add(root.val+"->"+rightResult.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.stringToTreeNode("[1,2,3,4,5,6,7,8,9,10]");
        TreeNodeUtil.prettyPrintTree(root);
        Solution257 solution257=new Solution257();
        List<String> result = solution257.binaryTreePaths(root);
        System.out.println(result);
    }
}
