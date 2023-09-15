package com.javademo.base.algorithm.leetcode.problems.recursive;


import com.javademo.base.algorithm.leetcode.problems.utils.TreeNode;
import com.javademo.base.algorithm.leetcode.problems.utils.TreeNodeUtil;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /12 22:05
 **/
public class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        if(root.val==sum){
            if(root.left==null&&root.right==null){
                return true;
            }/*else {//可能存在负数 不能直接返回false
                return false;
            }*/
        }
        boolean hasPathSum1=false;
        boolean hasPathSum2=false;
        if(root.left!=null){
             hasPathSum1 = hasPathSum(root.left, sum - root.val);
        }
        if(root.right!=null){
             hasPathSum2 = hasPathSum(root.right, sum - root.val);
        }
        return hasPathSum1||hasPathSum2;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.stringToTreeNode("[1,-2,-3,1,3,-2,null,-1]");
        TreeNodeUtil.prettyPrintTree(root);
        Solution112 solution112=new Solution112();
        boolean hasPathSum = solution112.hasPathSum(root, -1);
        System.out.println(hasPathSum);

    }
}
