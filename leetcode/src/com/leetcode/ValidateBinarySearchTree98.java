package com.leetcode;

/**
 * @author zlCalma
 * @date 2019/1/8 22:57.
 */
public class ValidateBinarySearchTree98 {

    public boolean isValidBST(TreeNode root) {

        return helper(root,null,null);
    }

    public boolean helper(TreeNode root,TreeNode left,TreeNode right){
        if(root == null){
            return true;
        }

        if(left != null && root.val <= left.val){
            return false;
        }

        if(right != null && root.val >= right.val){
            return false;
        }

        return helper(root.left,left,root)&&helper(root.right,root,right);
    }

}
