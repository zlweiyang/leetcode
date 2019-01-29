package com.leetcode.tree;

import com.leetcode.TreeNode;

/**
 * @author zlCalma
 * @date 2019/1/27 20:21.
 */
public class SubtreeofAnotherTree572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null){
            return t == null;//如果s==null,只有当t也为空时才能返回true，否则继续判断
        }
        //基本思想是找到相等那个值，然后递归左右子树
        return isSame(s,t)||isSubtree(s.left,t)||isSubtree(s.right,t);
    }
    //判断两个节点的值是否相等
    public boolean isSame(TreeNode s,TreeNode t){
        if(t == null || s == null){
            return s==t;//只有两个都为null吗，才能认为null值相等
        }
        //如果存在一个相等的值，则继续判断左右子树
        return s.val == t.val && isSame(s.left,t.left) && isSame(s.right,t.right);
    }
}
