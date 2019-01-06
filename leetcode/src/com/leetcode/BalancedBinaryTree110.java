package com.leetcode;

/**
 * @author zlCalma
 * @date 2019/1/6 23:28.
 */
public class BalancedBinaryTree110 {

    public boolean isBalanced(TreeNode root) {

        if(root == null){
            return true;
        }
        if(Math.abs(getDepth(root.left) - getDepth(root.right)) > 1){
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }

    public int getDepth(TreeNode root){
        //int depth = 0;
        if(root == null){
            return 0;
        }

        return Math.max(getDepth(root.left),getDepth(root.right))+1;
    }
}
