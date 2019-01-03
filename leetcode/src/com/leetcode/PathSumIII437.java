package com.leetcode;

/**
 * @author zlCalma
 * @date 2019/1/1 18:35.
 * DFS效率不高，可是更简单
 */
public class PathSumIII437 {

    public int pathSum(TreeNode root, int sum) {

        if(root == null){
            return 0;
        }

        return pathSum(root.left,sum)+pathSum(root.right,sum)+helper(root,sum);

    }

    public int helper(TreeNode node,int sum){
        if(node == null){
            return 0;
        }
        return (node.val == sum? 1:0)+helper(node.left,sum-node.val)+helper(node.right,sum-node.val);
    }
}
