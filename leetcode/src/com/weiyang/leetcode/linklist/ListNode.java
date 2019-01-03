package com.weiyang.leetcode.linklist;

public class ListNode {
    public Integer val;
    public ListNode next;
    public ListNode(Integer x){val = x;}
    public ListNode(){

    }
    public ListNode(Integer x,ListNode node){
        val = x;
        next = node;
    }

    public void insertAtBeginning(int destination) {
    }
}
