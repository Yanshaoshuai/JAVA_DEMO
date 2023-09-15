package com.javademo.base.algorithm.leetcode.problems.list;


import com.javademo.base.algorithm.leetcode.problems.utils.ListNode;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /04 21:18
 **/
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead=new ListNode(0);
        ListNode curNewNode=newHead;
        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
               curNewNode.next=l1;
               curNewNode=curNewNode.next;
                l1=l1.next;
            }else {
                curNewNode.next=l2;
                curNewNode=curNewNode.next;
                l2=l2.next;
            }

        }
        ListNode longNode=l1!=null?l1:l2;
        while (longNode!=null){
            curNewNode.next=longNode;
            curNewNode=curNewNode.next;
            longNode=longNode.next;
        }
        return newHead.next;
    }
}
