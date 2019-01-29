package com.leetcode.linkedlist;

import com.weiyang.leetcode.linklist.ListNode;

/**
 * @author zlCalma
 * @date 2019/1/28 21:42.
 *给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class RemoveNthNodeFromEndofList19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode end = head;//先指针
        ListNode pre = head;//后指针
        for (int i = 1; i <= n; i++) {
            end = end.next;//先走n步
        }
        if (end == null) {//刚好走完链表
            return pre.next;//删除第一个链表
        }
        while (end.next != null) {//走到先指针为空时，当好为倒数第n个指针
            end = end.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;//删除
        return head;
    }
}
