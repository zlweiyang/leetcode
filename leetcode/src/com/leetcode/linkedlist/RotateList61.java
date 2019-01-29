package com.leetcode.linkedlist;

import com.weiyang.leetcode.linklist.ListNode;

/**
 * @author zlCalma
 * @date 2019/1/27 22:20.
 */
public class RotateList61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode res = null;
        ListNode fast = head;
        ListNode slow = head;
        int count = 0;
        while(fast != null){
            count++;
            fast = fast.next;
        }
        fast = head;
        k = k%count;
        count = 0;
        while(count != k){
            fast = fast.next;
            count++;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        res = slow.next;
        slow.next = null;
        return res;
    }
}
