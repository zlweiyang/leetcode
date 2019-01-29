package com.leetcode.linkedlist;

import com.leetcode.ListNode;

/**
 * @author zlCalma
 * @date 2019/1/2 15:55.
 *
 * 归并排序分为三步
 * 1.找到中点
 * 2.递归二分
 * 3.进行合并
 */
public class SortList148 {

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = head;
        ListNode middle=getMiddle(head);

        ListNode next = middle.next;
        middle.next = null;

        ListNode l1 = sortList(prev);
        ListNode l2 = sortList(next);
        return merge(l1,l2);
    }
    public ListNode getMiddle(ListNode node){
        ListNode slow = node;
        ListNode fast = node;
        while(fast.next != null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode merge(ListNode l1,ListNode l2){

        ListNode res = new ListNode(0);
        ListNode temp = res;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                temp.next = l1;
                l1=l1.next;
            }else{
                temp.next = l2;
                l2=l2.next;
            }
            temp = temp.next;
        }
        if(l1!=null){
            temp.next = l1;
        }
        if(l2!=null){
            temp.next = l2;
        }
        return res.next;
    }

}
