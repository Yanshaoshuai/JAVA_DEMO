package com.javademo.base.algorithm.leetcode.problems.list;


import com.javademo.base.algorithm.leetcode.problems.utils.ListNode;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /04 21:30
 **/
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        ListNode p=dummyHead;
        ListNode node1=null;
        ListNode node2=null;
        while (p.next!=null&&p.next.next!=null){
            node1=p.next;
            node2=node1.next;
            node1.next=node2.next;
            node2.next=node1;
            p.next=node2;
            //下一对前节点
            p=node1;
        }
        return dummyHead.next;
    }
}
