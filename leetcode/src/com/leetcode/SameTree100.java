package com.leetcode;

/**
 * @author zlCalma
 * @date 2019/1/6 22:30.
 */
public class SameTree100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p==null && q==null){
            return true;
        }
        else if(p==null){
            return false;
        }
        else if(q==null){
            return false;
        }
        if(p.val == q.val){
            //return true;
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }else{
            return false;
        }
    }
}
