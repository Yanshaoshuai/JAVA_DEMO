package com.javademo.base.algorithm.leetcode.problems.recursive;


import com.javademo.base.algorithm.leetcode.problems.utils.TreeNode;
import com.javademo.base.algorithm.leetcode.problems.utils.TreeNodeUtil;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /13 16:10
 **/
public class Solution98 {
    public boolean isValidBST(TreeNode root) {
       boolean result=isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
       return result;
    }

    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if(root==null){
            return true;
        }
        if(root.val>=maxValue||root.val<=minValue){
            return false;
        }
        return isValidBST(root.left,minValue,root.val)//左子树小于当前值
                &&isValidBST(root.right,root.val,maxValue);//右子树大于当前值
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.stringToTreeNode("[3,1,5,0,2,4,6,null,null,null,3]");
        TreeNodeUtil.prettyPrintTree(root);
        Solution98 solution98=new Solution98();
        boolean isValidBST = solution98.isValidBST(root);
        System.out.println(isValidBST);
    }
}
