package com.weiyang.leetcode.linklist;

import java.lang.management.LockInfo;

public class MyLinkedList {

    public ListNode head;
    public ListNode tail;
    public int len;

    public MyLinkedList(){
        head = new ListNode(0);
        tail = head;
        int len = 0;
    }

    public int get(int index){

        ListNode tmp = head;
        if(index >= len) return -1;
        while(index >= 0){
            tmp = tmp.next;
            index--;
        }
        return tmp.val;
    }


    public void addAtHead(int val){
        ListNode tmp = new ListNode(0);
        tmp.val = val;
        tmp.next = head.next;
        head.next = tmp;
        len++;
    }

    public void addAtTail(int val){
        ListNode tmp = new ListNode(0);
        tmp.val = val;
        while(tail.next != null)
            tail = tail.next;
        tail.next = tmp;
        tmp.next = null;

        len++;
    }

    public void addAtIndex(int index,int val){
        ListNode pre = head;
        ListNode temp = new ListNode(0);
        temp.val = val;
        if(index <= len){
            while(index > 0){
                index--;
                pre = pre.next;
            }

            temp.next = pre.next;
            pre.next = temp;

            len++;
        }
    }

    public void deleteAtIndex(int index){
        ListNode tmp = head;
        if(index < len){
            while (index > 0){
                index--;
                tmp = tmp.next;
            }

            tmp.next = tmp.next.next;
            len--;
        }
    }

}
