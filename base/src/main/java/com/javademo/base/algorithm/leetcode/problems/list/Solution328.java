package com.javademo.base.algorithm.leetcode.problems.list;


import com.javademo.base.algorithm.leetcode.problems.utils.ListNode;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /04 14:15
 **/
public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode oddHead=head;
        ListNode eventHead=head.next;
        ListNode oddNode=oddHead;
        ListNode eventNode=eventHead;
        head=head.next.next;
        int i=3;
        while (head!=null){
            if(i%2==0){
               eventNode.next=head;
               eventNode=head;
            }else {
                oddNode.next=head;
                oddNode=head;
            }
            i++;
            head=head.next;
        }
        oddNode.next=eventHead;
        eventNode.next=null;
        return oddHead;
    }
}
