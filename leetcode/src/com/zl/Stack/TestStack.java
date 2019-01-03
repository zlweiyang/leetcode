package com.zl.Stack;

public class TestStack {
    public static void main(String[]args){
//        ArrayStack arrayStack = new ArrayStack(5);
//        if(arrayStack.isEmpty()){
//            System.out.println("Stack is Empty");
//        }
//        arrayStack.push(2);
//        arrayStack.push(3);
//        arrayStack.push(4);
//        System.out.println(arrayStack.size());
//
//        int len = arrayStack.size();
//
//        for(int i=0;i<len;i++) {
//            System.out.println(arrayStack.pop());
//        }

        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push(2);
        linkedStack.push(3);
        linkedStack.push(4);
        int len = linkedStack.size();
        for(int i=0;i<len;i++){
            System.out.println(linkedStack.pop());
        }


    }
}
