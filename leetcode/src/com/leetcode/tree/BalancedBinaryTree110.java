package com.leetcode.tree;

import com.leetcode.TreeNode;

/**
 * @author zlCalma
 * @date 2019/1/6 23:28.
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。

示例 1:

给定二叉树 [3,9,20,null,null,15,7]

3
/ \
9  20
/  \
15   7
返回 true 。
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

    //求树的最大深度
    public int getDepth(TreeNode root){
        //int depth = 0;
        if(root == null){
            return 0;
        }

        return Math.max(getDepth(root.left),getDepth(root.right))+1;
    }
}
