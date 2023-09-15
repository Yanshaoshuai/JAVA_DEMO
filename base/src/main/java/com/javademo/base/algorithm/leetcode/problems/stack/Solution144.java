package com.javademo.base.algorithm.leetcode.problems.stack;


import com.javademo.base.algorithm.leetcode.problems.utils.TreeNode;
import com.javademo.base.algorithm.leetcode.problems.utils.TreeNodeUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /11 21:00
 **/
public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new LinkedList<>();
        if(root!=null){
            preorder(root,result);
        }
        return result;
    }
    public void preorder(TreeNode node,List<Integer> result){
        if (node!=null){
            result.add(node.val);
            preorder(node.left,result);
            preorder(node.right,result);
        }
    }

    public static void main(String[] args) {
        Solution144 solution144=new Solution144();
        TreeNode root = TreeNodeUtil.stringToTreeNode("[2,1,3,4,5,6,2,1,3,4,5,6,2,1,3,4,5,6,2,1,3,4,5,6,2,1,3,4,5,6,2,1,3,4,5,6,2,1,3,4,5,6,2,1,3,4,5,6]");
        TreeNodeUtil.prettyPrintTree(root);
        List<Integer> list = solution144.preorderTraversal(root);
        System.out.println(list);
    }
}
