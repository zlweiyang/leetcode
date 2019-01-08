package com.leetcode;

/**
 * @author zlCalma
 * @date 2019/1/8 22:36.
 * 在判断左右大写时，可以根据正负号进行优化
 */
public class LowestCommonAncestorofaBinarySearchTree235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {


        if(root == null || root == p|| root == q){
            return root;
        }

        //如果p、q在二叉搜索树的两边，那么root就是他们的公共祖先
        if(((root.val > p.val)&&(root.val < q.val))||((root.val < p.val)&&(root.val > q.val))){
            return root;
        }
        //如果p，q在root的左边则递归调用左子树
        if((root.val > p.val)&&(root.val > q.val)){
            return lowestCommonAncestor(root.left,p,q);
        }else{
            //否则调用右子树
            return lowestCommonAncestor(root.right,p,q);
        }

    }
}
