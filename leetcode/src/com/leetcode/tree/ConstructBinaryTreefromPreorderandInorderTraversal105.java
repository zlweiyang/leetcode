package com.leetcode.tree;

import com.leetcode.TreeNode;

/**
 * @author zlCalma
 * @date 2019/1/29 21:46.
 * 根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

3
/ \
9  20
/  \
15   7
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
        //return root;
    }

    public TreeNode helper(int [] preorder,int [] inorder,int prebegin,int preend,int inbegin,int inend){

        if(prebegin > preend || inbegin >inend){
            return null;
        }
        TreeNode node = new TreeNode(preorder[prebegin]);
        for(int i=inbegin;i<=inend;i++){
            if(inorder[i] == preorder[prebegin]){
                node.left = helper(preorder,inorder,prebegin+1,prebegin+i-inbegin,inbegin,i-1);
                node.right = helper(preorder,inorder,prebegin+i+1-inbegin,preend,i+1,inend);
            }
        }
        return node;
    }
}
