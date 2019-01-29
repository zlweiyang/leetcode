package com.leetcode.tree;

import com.leetcode.TreeNode;

/**
 * @author zlCalma
 * @date 2019/1/6 23:24.
 */
public class CountCompleteTreeNodes222 {

    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        TreeNode left = root;
        TreeNode right = root;

        int height = 0;
        while(right != null){
            left = left.left;
            right=right.right;
            height++;
        }

        if(left == null){
            return (1<<height)-1;//满二叉树
        }else{
            return 1+countNodes(root.left)+countNodes(root.right);
        }
    }
}
