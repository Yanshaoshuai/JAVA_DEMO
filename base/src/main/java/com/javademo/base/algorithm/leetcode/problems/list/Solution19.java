package com.javademo.base.algorithm.leetcode.problems.list;


import com.javademo.base.algorithm.leetcode.problems.utils.ListNode;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /04 22:41
 **/
public class Solution19 {
    /**
     * 快慢指针，快指针先走n步，然后快慢一起走，直到快指针走到最后
     * 一次遍历
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        ListNode pre=dummyHead;
        ListNode last=head;
        int i=0;
        while (last!=null){
            if(i!=n){
                last=last.next;
                i++;
                continue;
            }
            last=last.next;
            pre=pre.next;
        }
        pre.next=pre.next.next;
        return dummyHead.next;
    }
}
