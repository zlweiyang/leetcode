package com.leetcode;

/**
 * @author zlCalma
 * @date 2019/1/6 22:18.
 */
public class MinimumDepthofBinaryTree111 {

    public int minDepth(TreeNode root) {

        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;//关键找到最后左右孩子都为空
        }
        int left_depth=0;
        int right_depth=0;
        if(root.left != null){
            left_depth = minDepth(root.left);
        }else{
            left_depth =  Integer.MAX_VALUE;//最大值的应用，如果只有左孩子或者右孩子为空，不能表示最小深度
        }
        if(root.right != null){
            right_depth = minDepth(root.right);
        }else{
            right_depth = Integer.MAX_VALUE;
        }
        return Math.min(left_depth,right_depth)+1;
    }
}
