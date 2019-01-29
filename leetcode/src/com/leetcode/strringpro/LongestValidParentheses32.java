package com.leetcode.strringpro;

import java.util.Stack;

/**
 * @author zlCalma
 * @date 2018/12/28 14:27.
 * 该方法不太好，另有滑窗法较好
 */
public class LongestValidParentheses32 {

    public int longestValidParentheses(String s) {
        int count = 0;
        int start = -1;//其实标志位，方便做重置
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(i);
                //start = i;//重置起始位
            }else{
                if(stack.isEmpty()){
                    //count = Math.max(count,i-start);
                    start = i;
                }else{
                    stack.pop();
                    if(stack.isEmpty()){
                        count = Math.max(count,i-start);
                    }else{
                        count = Math.max(count,i-stack.peek());
                    }
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        LongestValidParentheses32 l = new LongestValidParentheses32();
        System.out.println(l.longestValidParentheses(")()(()()()"));
    }
}
