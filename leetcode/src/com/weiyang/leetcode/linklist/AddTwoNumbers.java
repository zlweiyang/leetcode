package com.weiyang.leetcode.linklist;

import java.util.Stack;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        while(l1!=null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2!=null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int num = 0;
        int sum = 0;
        ListNode result = new ListNode(0);
        while(!stack1.empty() || !stack2.empty()||num!=0){
            sum = (!stack1.empty()? stack1.pop():0) + (!stack2.empty()? stack2.pop():0) + num;
            ListNode node = new ListNode(0);
            result.val = sum%10;
            node.next = result;
            result = node;
            num = sum/10;

        }

        return result.val == 0? result.next : result;
    }

    public static void main(String []args){

//        MyLinkedList linkedList = new MyLinkedList();
//        linkedList.addAtHead(1);
//        linkedList.addAtTail(3);
//        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//        System.out.println(linkedList.get(1));            //返回2
//        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//        System.out.println(linkedList.get(1));

        MyLinkedList l1 =  new MyLinkedList();
        MyLinkedList l2 = new MyLinkedList();
        l1.addAtTail(7);
        l1.addAtTail(2);
        l1.addAtTail(4);
        l1.addAtTail(3);
        l2.addAtTail(5);
        l2.addAtTail(6);
        l2.addAtTail(4);
//
//
        AddTwoNumbers add = new AddTwoNumbers();
        ListNode list = new ListNode(0);
        list = add.addTwoNumbers(l1.head,l2.head);
//        //System.out.println(l1.len);
//        ListNode temp = l1.head;
//        while(temp != null){
//            System.out.println(temp.val);
//        }
        while(list!=null){
            System.out.println(list.val);
            list = list.next;
        }
    }
}
