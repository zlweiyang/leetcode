package com.leetcode.strringpro;

import java.util.Stack;

/**
 * @author zlCalma
 * @date 2019/1/22 23:04.
 * 整体思路是字符串遍历，这个题目很好的利用了栈的特性
 */
public class DecodeString394 {
    class Solution {
        public String decodeString(String s) {
            if(s.length() == 0){
                return "";
            }
            Stack<Integer> numstack = new Stack<Integer>();
            Stack<String> strstack = new Stack<String>();
            StringBuilder res = new StringBuilder("");
            int index = 0;
            while(index < s.length()){
                //计算数字
                if(Character.isDigit(s.charAt(index))){
                    int num = 0;
                    while(Character.isDigit(s.charAt(index))){
                        num = num*10 + (s.charAt(index) - '0');
                        index++;
                    }
                    numstack.push(num);
                }
                //当遇到[时，需要将之前的结果res存入栈中，并清除
                else if(s.charAt(index) == '['){
                    strstack.push(res.toString());
                    res = new StringBuilder("");
                    index++;
                }
                //重新添加的res在遇到]后，再次与上次的res进行组合
                else if(s.charAt(index) == ']'){
                    StringBuilder str = new StringBuilder(strstack.pop());
                    //栈顶元素为当前范围的数量
                    int num = numstack.pop();
                    for(int i=0;i<num;i++){
                        str.append(res.toString());
                    }
                    res = str;
                    index++;
                    //清除res主要是为了这里重新添加res
                }else{
                    res.append(s.charAt(index++));
                }
            }
            return res.toString();
        }
    }
}
