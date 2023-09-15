package com.javademo.base.algorithm.leetcode.problems.list;


import com.javademo.base.algorithm.leetcode.problems.utils.ListNode;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /04 16:42
 **/
public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode curNode=head;
        //使头的值不为val
        while (head!=null&&head.val==val){
                head=head.next;
                curNode=head;
        }
        while (curNode!=null){
            if(curNode.next!=null&&curNode.next.val==val){
                curNode.next=curNode.next.next;
                //比较新的next
                continue;
            }
            curNode=curNode.next;
        }
        return head;
    }

    /**
     * dummyHead 虚拟头节点
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        ListNode curNode=dummyHead;
        while (curNode!=null){
            if(curNode.next!=null&&curNode.next.val==val){
                curNode.next=curNode.next.next;
                //比较新的next
                continue;
            }
            curNode=curNode.next;
        }
        return dummyHead.next;
    }
}
