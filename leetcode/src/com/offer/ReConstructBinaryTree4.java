package com.offer;

import com.leetcode.TreeNode;

/**
 * @author zlCalma
 * @date 2019/1/16 23:10.
 */
public class ReConstructBinaryTree4 {

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return helper(pre,0,pre.length-1,in,0,in.length-1);
    }

    public TreeNode helper(int[] pre, int prestart, int preend, int [] in, int instart, int inend){
        //递归终止条件
        if(prestart > preend || instart > inend){
            return null;
        }
        //根节点
        TreeNode root = new TreeNode(pre[prestart]);
        for(int i=instart;i<=inend;i++){
            if(in[i] == pre[prestart]){
                //重建左子树
                root.left = helper(pre,prestart+1,i-instart+prestart,in,instart,i-1);
                //重建右子树
                root.right = helper(pre,i-instart+prestart+1,preend,in,i+1,inend);
            }
        }
        return root;
    }
}
