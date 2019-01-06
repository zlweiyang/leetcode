package com.leetcode;

/**
 * @author zlCalma
 * @date 2019/1/6 23:47.
 */
public class PathSum112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;

        }
        return check(root,0,sum);
    }

    public boolean check(TreeNode node,int sum,int a){
        if(node == null && sum == a) return true;
        if(node == null) return false;
        if(node.left == null&&node.right!=null) return check(node.right,sum+node.val,a);
        if(node.left!=null && node.right == null) return check(node.left,sum+node.val,a);

        return check(node.left,sum+node.val,a)||check(node.right,sum+node.val,a);

    }
}
