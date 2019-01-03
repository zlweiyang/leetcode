package com.leetcode;

/**
 * @author zlCalma
 * @date 2018/12/29 10:03.
 * 基本思路：后序遍历
 * 1.如果仅仅在左边找到，那就返回left
 * 2.如果仅仅在右边找到，那就返回right
 * 3.如果在左右两边都找到那就返回root
 */
public class LowestCommonAncestorofaBinaryTree236 {

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            if (root == null || root == p || root == q) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null && right != null) {
                return root;
            } else {
                return left != null ? left : right;
            }

        }
    }

    public static void main(String[] args) {

    }
}
