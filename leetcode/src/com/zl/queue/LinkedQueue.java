package com.zl.queue;

import com.weiyang.leetcode.linklist.ListNode;

public class LinkedQueue {
    private ListNode frontnode;
    private ListNode rearnode;
    public LinkedQueue(){
        this.frontnode = null;
        this.rearnode = null;
    }
    public static LinkedQueue createQueue(){
        return new LinkedQueue();
    }
    public boolean isEmpty(){
        return (frontnode == null);
    }
    public void enQueue(int data){
        ListNode newnode = new ListNode(data);
        if(rearnode != null){
            rearnode.next = newnode;
        }
        rearnode = newnode;
        if(frontnode == null){
            frontnode = rearnode;
        }
    }

    public int deQueue(){
        Integer data = null;
        if(isEmpty()){
            System.out.println("Queue is Empty");
        }else{
            data = frontnode.val;
            frontnode = frontnode.next;
        }
        return data;
    }
}
