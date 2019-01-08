package com.leetcode;

import java.util.Stack;

/**
 * @author zlCalma
 * @date 2019/1/8 23:19.
 * 方法待优化
 */
public class KthSmallestElementinaBST230 {
    //static List<Integer> list = new ArrayList<Integer>();
    static Stack<Integer> stack = new Stack<Integer>();
    public int kthSmallest(TreeNode root, int k) {


        find(root);
        for(int i=0;i<k-1;i++){
            stack.pop();
        }
        //stack.pop();
        return stack.pop();


    }

    public static void find(TreeNode root){
        if(root == null) return;
        find(root.right);
        stack.push(root.val);
        find(root.left);
    }

}
