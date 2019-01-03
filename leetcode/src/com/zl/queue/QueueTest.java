package com.zl.queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class QueueTest {

    public static void main(String[] args){
        //QueueTest queueTest = new QueueTest(5);
//        ArrayQueue arrayQueue = new ArrayQueue(5);
//        if(arrayQueue.isEmpty()){
//            System.out.println("Queue is Empty");
//        }
//        arrayQueue.enQueue(3);
//        arrayQueue.enQueue(4);
//        arrayQueue.enQueue(5);
//        //int len  = arrayQueue.
//        while(!arrayQueue.isEmpty()){
//            System.out.println(arrayQueue.deQueue());
//        }
        LinkedList arrayList = new LinkedList();
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enQueue(4);
        linkedQueue.enQueue(5);
        System.out.println(linkedQueue.deQueue());
    }
}
