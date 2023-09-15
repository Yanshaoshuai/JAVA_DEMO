package com.javademo.base.algorithm.leetcode.problems.list;


import com.javademo.base.algorithm.leetcode.problems.utils.ListNode;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /03 21:37
 **/
public class Solution86 {
    /**
     * time O(n)
     * 双指针
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead=null;
        ListNode largeHead=null;
        ListNode curSmall=null;
        ListNode curLarge=null;
        while (head!=null){
            if(head.val>=x){
                if(largeHead!=null){
                    curLarge.next=head;
                    curLarge=head;
                }else {
                    largeHead=head;
                    curLarge=largeHead;
                }
            }else {
                if(smallHead!=null){
                    curSmall.next=head;
                    curSmall=head;
                }else {
                    smallHead=head;
                    curSmall=smallHead;
                }
            }
            head=head.next;
        }
        if(curSmall!=null){
            curSmall.next=largeHead;
        }
        if(curLarge!=null){
            curLarge.next=null;
        }
        if(smallHead!=null){
            return smallHead;
        }else if (largeHead!=null){
            return largeHead;
        }else {
            return null;
        }
    }

    public static void main(String[] args) {
        ListNode head=ListNode.createLinkedList(new int[]{1,4,3,2,5});
        ListNode.printLinkedList(head);
        Solution86 solution86=new Solution86();
        ListNode partitionHead = solution86.partition(head, 3);
        ListNode.printLinkedList(partitionHead);
    }
}
