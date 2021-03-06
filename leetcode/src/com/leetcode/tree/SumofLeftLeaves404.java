package com.leetcode.tree;

import com.leetcode.TreeNode;

/**
 * @author zlCalma
 * @date 2019/1/7 15:24.
 */
public class SumofLeftLeaves404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        int sum = 0;
        if(root.left != null && root.left.left == null && root.left.right == null){
            sum += root.left.val;
        }
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }
}
