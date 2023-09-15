package com.javademo.base.algorithm.leetcode.problems.list;


import com.javademo.base.algorithm.leetcode.problems.utils.ListNode;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /04 17:08
 **/
public class Solution82 {
    /**
     * 保留了1个重复元素
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode curNode=head;
        while (curNode!=null){
            if(curNode.next!=null&&curNode.val==curNode.next.val){
                curNode.next=curNode.next.next;
                continue;
            }
            curNode=curNode.next;
        }
        return head;
    }
    public ListNode deleteDuplicates3(ListNode head) {
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        ListNode pre=dummyHead;
        ListNode curMode=head;
        boolean safe=true;
        while (curMode!=null){
          if(curMode.next!=null&&curMode.next.val==curMode.val){
             curMode=curMode.next;
             safe=false;
             continue;
          }
          if(safe){
            pre.next=curMode;
            pre=pre.next;
          }
            safe=true;
            curMode=curMode.next;
        }
        pre.next=curMode;
        return dummyHead.next;
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        ListNode pre=dummyHead;
        ListNode curMode=head;
        while (curMode!=null){
            if(curMode.next!=null&&curMode.next.val==curMode.val){
                curMode=curMode.next;
                continue;
            }
            if( pre.next!=curMode){
                pre.next=curMode.next;
            }else {
                pre=pre.next;
            }
            curMode=curMode.next;
        }
        pre.next=curMode;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution82 solution82=new Solution82();
        ListNode head = solution82.deleteDuplicates(ListNode.createLinkedList(new int[]{1,1,1}));
        ListNode.printLinkedList(head);
    }
}
