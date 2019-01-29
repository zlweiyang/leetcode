package com.leetcode.stack;

import java.util.Stack;

/**
 * @author zlCalma
 * @date 2019/1/28 21:26.
 */
public class MinStack105 {

    Stack<Integer> stack ;
    Stack<Integer> min;
    /** initialize your data structure here. */
    public MinStack105() {
        stack = new Stack<>();
        min= new Stack<>();
    }
    public void push(int x) {
        stack.push(x);
        if(min.isEmpty() || (x <= min.peek())){
            min.push(x);
        }
    }
    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        Integer pop = stack.pop();
        if(min.peek().equals(pop)){
            min.pop();
        }
        //stack.pop();
    }
    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
