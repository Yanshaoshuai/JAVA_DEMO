package com.javademo.base.algorithm.leetcode.problems.list;


import com.javademo.base.algorithm.leetcode.problems.utils.ListNode;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /04 14:38
 **/
public class Solution2 {
    /**
     * 顺序
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersOrder(ListNode l1, ListNode l2) {
        ListNode resultHead=new ListNode(0);
        while (l1!=null&&l2!=null){
            int sum=l1.val+l2.val;
            if(sum>=10){
                sum=sum-10;
                resultHead.val=sum;
                if(l1.next!=null){
                    l1.next.val+=1;
                }else if(l2.next!=null){
                    l2.next.val+=1;
                }else {
                    ListNode newHead=new ListNode(1);
                    newHead.next=resultHead;
                    resultHead=newHead;
                    break;
                }
            }
            resultHead.val=sum;
            ListNode newHead=new ListNode(0);
            newHead.next=resultHead;
            resultHead=newHead;
            l1=l1.next;
            l2=l2.next;
        }
        ListNode longNode=l1!=null?l1:l2;
       while (longNode!=null){
          int sum=longNode.val;
          if(sum>=10){
              sum=sum-10;
              resultHead.val=sum;
              if(longNode.next!=null){
                  longNode.next.val+=1;
              }else {
                  ListNode newHead=new ListNode(1);
                  newHead.next=resultHead;
                  resultHead=newHead;
                  break;
              }
          }
           resultHead.val=sum;
           ListNode newHead=new ListNode(0);
           newHead.next=resultHead;
           resultHead=newHead;
           longNode=longNode.next;
       }
       return resultHead.next;
    }

    /**
     * 逆序
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultHead=null;
        ListNode curResult=null;
        while (l1!=null&&l2!=null){
            if(resultHead!=null){
                ListNode newNode=new ListNode(0);
                curResult.next=newNode;
                curResult=curResult.next;
            }else {
                resultHead=new ListNode(0);
                curResult=resultHead;
            }
            int sum=l1.val+l2.val;
            if(sum>=10){
                sum=sum-10;
                curResult.val=sum;
                if(l1.next!=null){
                    l1.next.val+=1;
                }else if(l2.next!=null){
                    l2.next.val+=1;
                }else {
                    ListNode newNode=new ListNode(1);
                    curResult.next=newNode;
                    curResult=curResult.next;
                    l1=l1.next;
                    l2=l2.next;
                    break;
                }
            }
            curResult.val=sum;
            l1=l1.next;
            l2=l2.next;
        }
        ListNode longNode=l1!=null?l1:l2;
       while (longNode!=null){
           if(resultHead!=null){
               ListNode newNode=new ListNode(0);
               curResult.next=newNode;
               curResult=curResult.next;
           }else {
               resultHead=new ListNode(0);
               curResult=resultHead;
           }
          int sum=longNode.val;
          if(sum>=10){
              sum=sum-10;
              curResult.val=sum;
              if(longNode.next!=null){
                  longNode.next.val+=1;
              }else {
                  ListNode newNode=new ListNode(1);
                  curResult.next=newNode;
                  break;
              }
          }
           curResult.val=sum;

           longNode=longNode.next;
       }
       return resultHead;
    }

    public static void main(String[] args) {
        Solution2 solution2=new Solution2();
        ListNode head = solution2.addTwoNumbers
                (ListNode.createLinkedList(new int[]{9,9}),
                        ListNode.createLinkedList(new int[]{9}));
        ListNode.printLinkedList(head);
    }
}
