package com.javademo.base.algorithm.leetcode.problems.utils;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /03 21:06
 **/
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
    public static ListNode createLinkedList(int[] arr){
        if(arr.length==0){
            return null;
        }
        ListNode head=new ListNode(arr[0]);
        ListNode curNode=head;
        for (int i = 1; i < arr.length; i++) {
            curNode.next=new ListNode(arr[i]);
            curNode=curNode.next;
        }
        return head;
    }
    public static void printLinkedList(ListNode head){
        ListNode curNode=head;
       while (curNode!=null){
           System.out.print(curNode.val+" -> ");
           curNode=curNode.next;
       }
       System.out.println("null");
    }
}
