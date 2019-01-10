package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zlCalma
 * @date 2019/1/7 23:17.
 */
public class PathSumII113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> res = new ArrayList<>();
        //List<Integer> temp = new ArrayList<>();
        helper(root,sum, new ArrayList<>(), res);
        return res;
    }

    private void helper(TreeNode root, int sum, ArrayList<Object> objects, List<List<Integer>> res) {
    }

    public void helper(TreeNode root,int sum,List<List<Integer>> res,List<Integer> temp){
        if(root == null){
            return;
        }
        //List<Integer> temp = new ArrayList<>();
        if(root.left == null && root.right == null && sum==root.val){
            temp.add(root.val);
            res.add(temp);
            return;

        }
        //上述为递归终止条件
        temp.add(root.val);
        if(root.left != null){
            //temp.add(root.val);
            List<Integer> list = new ArrayList<Integer>(temp);
            helper(root.left,sum-root.val,res,list);
        }
        if(root.right != null){
            //temp.add(root.val);
            List<Integer> list = new ArrayList<Integer>(temp);
            helper(root.right,sum-root.val,res,list);
        }
    }
}
