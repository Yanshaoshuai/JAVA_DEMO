package com.javademo.base.algorithm.leetcode.problems.recursive;


import com.javademo.base.algorithm.leetcode.problems.utils.TreeNode;
import com.javademo.base.algorithm.leetcode.problems.utils.TreeNodeUtil;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /12 22:49
 **/
public class Solution404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftLeftSum = sumOfLeftLeaves(root.left);
        int rightLeftSum = sumOfLeftLeaves(root.right);
        if(root.left!=null&&root.left.left==null&&root.left.right==null){
            //是左叶子 返回左叶子+左树左叶子+右树左叶子
            return root.left.val+leftLeftSum+rightLeftSum;
        }else{
            //不是左叶子 返回左树左叶子+右树左叶子
            return leftLeftSum+rightLeftSum;
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.stringToTreeNode("[1,2,3,4,5]");
        TreeNodeUtil.prettyPrintTree(root);
        Solution404 solution404=new Solution404();
        int sum = solution404.sumOfLeftLeaves(root);
        System.out.println(sum);
    }
}
