package com.leetcode;

/**
 * @author zlCalma
 * @date 2019/1/6 22:17.
 */
public class MaximumDepthofBinaryTree104 {

    public int maxDepth(TreeNode root) {

        if(root == null){
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left,right) + 1;

    }
}
