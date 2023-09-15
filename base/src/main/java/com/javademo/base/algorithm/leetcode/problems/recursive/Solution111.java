package com.javademo.base.algorithm.leetcode.problems.recursive;


import com.javademo.base.algorithm.leetcode.problems.utils.TreeNode;
import com.javademo.base.algorithm.leetcode.problems.utils.TreeNodeUtil;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /12 20:43
 **/
public class Solution111 {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int minDepthLeft = minDepth(root.left);
        int minDepthRight = minDepth(root.right);
        if(minDepthLeft==0&&minDepthRight!=0){
            return minDepthRight+1;
        }else if(minDepthLeft!=0&&minDepthRight==0){
            return minDepthLeft+1;
        }
        return Math.min(minDepthLeft,minDepthRight)+1;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.stringToTreeNode("[3,9,20,22,null,15,7]");
        TreeNodeUtil.prettyPrintTree(root);
        Solution111 solution111=new Solution111();
        int minDepth = solution111.minDepth(root);
        System.out.println(minDepth);
    }
}
