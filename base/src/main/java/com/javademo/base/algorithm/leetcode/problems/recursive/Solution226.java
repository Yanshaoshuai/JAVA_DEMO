package com.javademo.base.algorithm.leetcode.problems.recursive;


import com.javademo.base.algorithm.leetcode.problems.utils.TreeNode;
import com.javademo.base.algorithm.leetcode.problems.utils.TreeNodeUtil;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /12 20:50
 **/
public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left=root.right;
        root.right=temp;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.stringToTreeNode("[1,2,2,3,4,4,3]");
        TreeNodeUtil.prettyPrintTree(root);
        Solution226 solution226=new Solution226();
        root = solution226.invertTree(root);
        TreeNodeUtil.prettyPrintTree(root);
    }
}
