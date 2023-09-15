package com.javademo.base.algorithm.leetcode.problems.list;


import com.javademo.base.algorithm.leetcode.problems.utils.ListNode;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /03 17:53
 **/
public class Solution206 {
    public ListNode reverseList(ListNode head) {
      ListNode pre=null;
      ListNode cur=head;
      while (cur!=null){
          //保存next
          ListNode next=cur.next;
          //在头部插入
          cur.next=pre;
          pre=cur;
          //循环下一个节点
          cur=next;
      }
      return pre;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode.printLinkedList(head);
        Solution206 solution206=new Solution206();
        ListNode head2 = solution206.reverseList(head);
        ListNode.printLinkedList(head2);
    }
}
