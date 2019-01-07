package com.leetcode;

/**
 * @author zlCalma
 * @date 2019/1/7 23:40.
 */
public class SumRoottoLeafNumbers129 {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        helper(root);
        return sum;
    }
    public void helper(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left==null&&root.right==null){
            sum += root.val;
        }
        if(root.left != null){
            root.left.val += root.val*10 ;
            helper(root.left);
        }
        if(root.right != null){
            root.right.val += root.val*10;
            helper(root.right);
        }
    }
}
