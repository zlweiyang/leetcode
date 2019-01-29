package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zlCalma
 * @date 2019/1/25 22:42.
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

[
"((()))",
"(()())",
"(())()",
"()(())",
"()()()"
]
 经典的回溯题，一般需要生成列表的都是用回溯
 */
public class GenerateParentheses22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res,"",0,0,n);
        return res;
    }
    public void backtrack(List<String> res, String tmp, int left, int right, int n){
        if(tmp.length() == 2*n){
            res.add(tmp);
        }
        if(left<n){
            backtrack(res,tmp+"(",left+1,right,n);
        }
        //这里很关键，只有左边先存在的时候才能添加右边
        if(right<left){
            backtrack(res,tmp+")",left,right+1,n);
        }
    }
}
