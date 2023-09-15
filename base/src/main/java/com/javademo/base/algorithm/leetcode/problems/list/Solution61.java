package com.javademo.base.algorithm.leetcode.problems.list;


import com.javademo.base.algorithm.leetcode.problems.utils.ListNode;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /04 22:56
 **/
public class Solution61 {
    /**
     * todo 待优化
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0||head.next==null){
            return head;
        }
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        ListNode pre=dummyHead;
        ListNode last=head;
        while (--k!=0){
            last=last.next;
            if(last==null){
                last=head;
            }
        }
        while (last.next!=null){
            last=last.next;
            pre=pre.next;
        }
        if(pre.next==head){
            return head;
        }
        last.next=head;
        head=pre.next;
        pre.next=null;
        return head;
    }

    public static void main(String[] args) {
        Solution61 solution61=new Solution61();
        ListNode listNode = solution61.rotateRight(ListNode.createLinkedList(new int[]{1, 2}), 2);
        ListNode.printLinkedList(listNode);
    }
}
