package com.leetcode.tree;

import com.leetcode.TreeNode;

/**
 * @author zlCalma
 * @date 2019/1/9 23:24.
 */
public class DeleteNodeinaBST450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }

        if(root.val == key){
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }

            TreeNode node = root.right;
            while(node.left!=null){
                node = node.left;
            }
            node.left = root.left;
            return root.right;
        }

        else if(root.val < key){
            TreeNode  node = deleteNode(root.right,key);
            root.right = node;
            return root;
        }else{
            TreeNode node = deleteNode(root.left,key);
            root.left = node;
            return root;
        }

    }
}
