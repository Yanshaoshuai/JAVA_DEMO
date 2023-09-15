package com.javademo.base.algorithm.leetcode.problems.list;


import com.javademo.base.algorithm.leetcode.problems.utils.ListNode;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /04 22:08
 **/
public class Solution237 {
    public void deleteNode2(ListNode node) {
        ListNode preNode=node;
        node=node.next;
        while (node.next!=null){
            preNode.val=node.val;
            node=node.next;
            preNode=preNode.next;
        }
        preNode.val=node.val;
        preNode.next=null;
    }

    /**
     * 直接改值
     * @param node
     */
    public void deleteNode(ListNode node) {
       node.val=node.next.val;
       node.next=node.next.next;
    }
}
