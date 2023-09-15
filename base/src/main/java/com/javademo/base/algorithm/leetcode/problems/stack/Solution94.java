package com.javademo.base.algorithm.leetcode.problems.stack;


import com.javademo.base.algorithm.leetcode.problems.utils.TreeNode;
import com.javademo.base.algorithm.leetcode.problems.utils.TreeNodeUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /11 21:32
 **/
public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new LinkedList<>();
        if(root!=null){
            inorder(root,result);
        }
        return result;
    }

    private void inorder(TreeNode root, List<Integer> result) {
        if(root!=null){
            inorder(root.left,result);
            result.add(root.val);
            inorder(root.right,result);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.stringToTreeNode("[1,2,3,4,5,6]");
        TreeNodeUtil.prettyPrintTree(root);
        Solution94 solution94=new Solution94();
        List<Integer> result = solution94.inorderTraversal(root);
        System.out.println(result);
    }
}
