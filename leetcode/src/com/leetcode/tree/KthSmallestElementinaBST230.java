package com.leetcode.tree;

import com.leetcode.TreeNode;

/**
 * @author zlCalma
 * @date 2019/1/29 23:06.
 */
public class KthSmallestElementinaBST230 {
    int index=0;

    public int kthSmallest(TreeNode root, int k) {
        int res = 0;
        if(root == null){
            return res;
        }

        res = kthSmallest(root.left,k);
        if(index == k){
            return res;
        }
        if(++index == k){
            return root.val;
        }
        res = kthSmallest(root.right,k);

        return res;

    }
}
