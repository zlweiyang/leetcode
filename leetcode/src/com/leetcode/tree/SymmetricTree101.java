package com.leetcode.tree;

import com.leetcode.TreeNode;

/**
 * @author zlCalma
 * @date 2018/12/31 16:52.
 */
public class SymmetricTree101 {
    public boolean isSymmetric(TreeNode root) {

        if(root == null){
            return true;
        }
        return helper(root.left,root.right);
    }
    public boolean helper(TreeNode left,TreeNode right){
        if(left == null ||right == null){
            return left == right;
        }
        if(left.val != right.val){
            return false;
        }
        return helper(left.left,right.right)&&helper(left.right,right.left);
    }

}
