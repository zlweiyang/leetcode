package com.leetcode.linkedlist;

import com.weiyang.leetcode.linklist.ListNode;

/**
 * @author zlCalma
 * @date 2019/1/28 21:37.
 * 反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
*/
public class ReverseLinkedList206 {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        //新的头结点
        ListNode root = null;
        ListNode temp = head;
        while(temp != null){
            temp = head.next;
            head.next = root;
            root = head;
            head = temp;
        }
        return root;
    }
}
