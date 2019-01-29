package com.leetcode.tree;

import com.leetcode.TreeNode;

/**
 * @author zlCalma
 * @date 2019/1/23 23:44.
 * 给定一个二叉树，原地将它展开为链表。

例如，给定二叉树

1
/ \
2   5
/ \   \
3   4   6
 */
public class FlattenBinaryTreetoLinkedList114 {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }
}
