package com.javademo.base.algorithm.leetcode.problems.stack;


import com.javademo.base.algorithm.leetcode.problems.utils.TreeNode;
import com.javademo.base.algorithm.leetcode.problems.utils.TreeNodeUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /11 21:49
 **/
public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new LinkedList<>();
        if(root!=null){
            postorder(root,result);
        }
        return result;
    }

    private void postorder(TreeNode root, List<Integer> result) {
        if(root!=null){
            postorder(root.left,result);
            postorder(root.right,result);
            result.add(root.val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.stringToTreeNode("[1,2,3,4,5,6]");
        TreeNodeUtil.prettyPrintTree(root);
        Solution145 solution94=new Solution145();
        List<Integer> result = solution94.postorderTraversal(root);
        System.out.println(result);
    }
}
