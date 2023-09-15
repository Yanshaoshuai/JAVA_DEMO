package com.javademo.base.algorithm.leetcode.problems.recursive;


import com.javademo.base.algorithm.leetcode.problems.utils.TreeNode;
import com.javademo.base.algorithm.leetcode.problems.utils.TreeNodeUtil;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /13 12:59
 **/
public class Solution437 {
    public int pathSum(TreeNode root, int sum) {
        if(root==null){
            return 0;
        }
        int result=findPathSum(root,sum);//当前节点开头 和为sum路径数量
        int resultLeft=pathSum(root.left,sum);//左节点开头 和为sum路径数量
        int resultRight=pathSum(root.right,sum);//右节点开头 和为sum路径数量
        return result+resultLeft+resultRight;
    }

    /**
     * 找到以root开头和为sum路径的数量
     * @param root
     * @param sum
     * @return
     */
    public int findPathSum(TreeNode root, int sum) {
        if(root==null){
            return 0;
        }
        int result=0;
        if(root.val==sum){//如果找到和为sum的则结果+1，因为有负数所以不能返回
            result+=1;
        }
        int  resultLeft = findPathSum(root.left, sum - root.val);//找到左子树中和为sum-当前值 的数量
        int  resultRight = findPathSum(root.right, sum - root.val);//找到右子树中和为sum-当前值 的 数量
        return result+resultLeft+resultRight;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.stringToTreeNode("[1,null,2,null,3,null,4,null,5]");
        TreeNodeUtil.prettyPrintTree(root);
        Solution437 solution437=new Solution437();
        int pathSum = solution437.pathSum(root, 3);
        System.out.println(pathSum);
    }
}
