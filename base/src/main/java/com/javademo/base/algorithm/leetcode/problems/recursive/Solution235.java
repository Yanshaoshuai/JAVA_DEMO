package com.javademo.base.algorithm.leetcode.problems.recursive;


import com.javademo.base.algorithm.leetcode.problems.utils.TreeNode;
import com.javademo.base.algorithm.leetcode.problems.utils.TreeNodeUtil;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /13 15:57
 **/
public class Solution235 {
    /**
     * 一个二叉搜索树具有如下特征：
     *
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        //如果都在左侧 递归左子树
        if(p.val<root.val&&q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        //如果都在右侧 递归右子树
        if(p.val>root.val&&q.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        //如果在两侧 那么root就是公共祖先
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.stringToTreeNode("[6,2,8,0,4,7,9,null,null,3,5]");
        TreeNodeUtil.prettyPrintTree(root);
        Solution235 solution235=new Solution235();
        TreeNode parentNode = solution235.lowestCommonAncestor(root, new TreeNode(7), new TreeNode(9));
        System.out.println(parentNode.val);
    }
}
