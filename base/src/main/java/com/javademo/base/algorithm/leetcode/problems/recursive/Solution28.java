package com.javademo.base.algorithm.leetcode.problems.recursive;


import com.javademo.base.algorithm.leetcode.problems.utils.TreeNode;
import com.javademo.base.algorithm.leetcode.problems.utils.TreeNodeUtil;

/**
 * @Author Mr.Yan
 * @Date 2020 / 10 /11 20:36
 **/
public class Solution28 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isSymmetricChild(root.left,root.right);
    }

    private boolean isSymmetricChild(TreeNode left,TreeNode right) {
        if((left==null&&right!=null)||(left!=null&&right==null)){
            return false;
        }
        if(left==null&&right==null){
            return true;
        }
        if(left.val!=right.val){
            return false;
        }
        return isSymmetricChild(left.left,right.right)&&isSymmetricChild(left.right,right.left);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtil.stringToTreeNode("[1,2,2,3,4,4,3]");
        System.out.println(new Solution28().isSymmetric(treeNode));
    }
}
