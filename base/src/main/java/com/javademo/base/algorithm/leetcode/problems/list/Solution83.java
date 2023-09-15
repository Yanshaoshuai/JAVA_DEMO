package com.javademo.base.algorithm.leetcode.problems.list;


import com.javademo.base.algorithm.leetcode.problems.utils.ListNode;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /03 21:23
 **/
public class Solution83 {
    /**
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curNode=head;
        while (curNode!=null){
            ListNode next=curNode.next;
            if(next!=null&&curNode.val==next.val){
                curNode.next=next.next;
            }else {
                curNode=curNode.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createLinkedList(new int[]{1, 1, 1});
        Solution83 solution83=new Solution83();
        head=solution83.deleteDuplicates(head);
        ListNode.printLinkedList(head);
    }
}
