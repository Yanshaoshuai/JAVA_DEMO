package com.javademo.base.algorithm.leetcode.problems.recursive;


import com.javademo.base.algorithm.leetcode.problems.utils.TreeNode;
import com.javademo.base.algorithm.leetcode.problems.utils.TreeNodeUtil;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /12 20:59
 **/
public class Solution101 {
    /**
     * todo
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        TreeNode newRoot = root;
        boolean isSame=isSame(root.left, root.right);
        return isSame;
    }

    private boolean isSame(TreeNode left, TreeNode right) {
        if(left==null&&right==null){
            return true;
        }else if(left!=null&&right==null){
            return false;
        }else if(left==null&&right!=null){
            return false;
        }
        boolean same1 = isSame(left.left, right.right);
        boolean same2 = isSame(left.right, right.left);
        return same1&&same2&&left.val==right.val;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.stringToTreeNode("[1,2,2,3,4,4,3]");
        Solution101 solution101=new Solution101();
        boolean symmetric = solution101.isSymmetric(root);
        System.out.println(symmetric);
    }
}
