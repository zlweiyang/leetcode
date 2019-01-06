package com.leetcode;

/**
 * @author zlCalma
 * @date 2019/1/6 22:20.
 */
public class InvertBinaryTree226 {

    public TreeNode invertTree(TreeNode root) {

        if(root == null){
            return root;
        }
        if(root.right == null && root.left==null){
            return root;
        }
        TreeNode node  = root.left;
        root.left = root.right;
        root.right = node;
        if(root.left != null){
            invertTree(root.left);
        }

        if(root.right != null){
            invertTree(root.right);
        }
        return root;
    }
}
