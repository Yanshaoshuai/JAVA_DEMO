package com.javademo.base.algorithm.leetcode.problems.recursive;


import com.javademo.base.algorithm.leetcode.problems.utils.TreeNode;
import com.javademo.base.algorithm.leetcode.problems.utils.TreeNodeUtil;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /12 20:30
 **/
public class Solution104 {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth=maxDepth(root.right);
        return Math.max(leftMaxDepth,rightMaxDepth)+1;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.stringToTreeNode("[1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10]");
        TreeNodeUtil.prettyPrintTree(root);
        Solution104 solution104=new Solution104();
        int maxDepth = solution104.maxDepth(root);
        System.out.println(maxDepth);
    }
}
