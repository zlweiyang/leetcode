package com.zl.Stack;

import com.weiyang.leetcode.linklist.ListNode;

public class LinkedStack {

    //private ListNode head;
    private ListNode top ;
    private int size;

    public LinkedStack(){
        this.top = new ListNode();
    }
    public int size(){
        return size;
    }
    public void push(Integer data){
        if( data == null){
            System.out.println("data can not be null");
        }
        if(this.top == null){
            this.top = new ListNode(data);
        }
        else if(top.val == null){
            this.top.val = data;
        }else{
            ListNode temp = new ListNode(data,this.top);
            top = temp;
        }
        size++;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return 0;
        }else{
            int data = top.val;
            top = top.next;
            size--;
            return data;

        }
    }
    public boolean isEmpty(){
       return top == null || top.val == null;
    }
    public void deleteStack(){
        //head =null;
        top = null;
    }


}
