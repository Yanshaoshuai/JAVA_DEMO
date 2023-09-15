package com.javademo.base.algorithm.leetcode.problems.queue;


import com.javademo.base.algorithm.leetcode.problems.utils.TreeNode;
import com.javademo.base.algorithm.leetcode.problems.utils.TreeNodeUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /12 14:27
 **/
public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new LinkedList<>();
        if(root==null){
            return result;
        }
        LinkedList<Pair> queue=new LinkedList<>();
        queue.offer(new Pair(root,0));
        while (!queue.isEmpty()){
            Pair front = queue.peek();
            TreeNode node=front.node;
            Integer level=front.level;
            queue.poll();
            if(level==result.size()){
                result.add(new LinkedList<>());
            }
            result.get(level).add(node.val);
            if(node.left!=null){
                queue.offer(new Pair(node.left,level+1));
           }
            if(node.right!=null){
                queue.offer(new Pair(node.right,level+1));
            }
        }
        return result;
    }
    class Pair{
        private TreeNode node;
        private Integer level;

        public Pair(TreeNode node, Integer level) {
            this.node = node;
            this.level = level;
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.stringToTreeNode("[1,2,3,4,5,6]");
        TreeNodeUtil.prettyPrintTree(root);
        Solution102 solution102=new Solution102();
        List<List<Integer>> lists = solution102.levelOrder(root);
        System.out.println(lists);
    }
}
