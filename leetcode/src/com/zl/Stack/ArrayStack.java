package com.zl.Stack;

/**
 * 基于简单数组实现栈
 * 栈只是我们认为抽象的一种数据结构
 * 使用数据作为底层存储结构则实际数据存储在数组中
 * 为了区别其它数据结构应具备其自身特点，比如栈顶top
 */
public class ArrayStack {

    private int top;
    private int capacity;
    private int[] array;
    public ArrayStack(int capacity){
        this.capacity = capacity;
        array = new int[capacity];
        top = -1;
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isFullStack(){
        return (top == capacity-1);
        //return top = array.length;
    }
    public void push(int data){
        if(isFullStack()) {System.out.println("Stack Overflow");}
        else {
            array[++top] = data;
        }
    }
    public int  pop(){
        if(isEmpty()) {
            System.out.println("Stack is Empty");
            return 0;
        }
        else {
            return array[top--];
        }
    }
    public void deleteStack(){
        top = -1;
    }

    public int size(){
        return top+1;
    }
}
