package com.leetcode.tree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zlCalma
 * @date 2019/1/7 22:37.
 *
 * 运行效率不如回溯
 */
public class BinaryTreePaths257 {
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> res = new ArrayList<>();

        if(root == null){
            return res;
        }
        if(root.left == null && root.right == null){
            res.add(String.valueOf(root.val));
            return res;
        }

        //上面是递归终止条件，下面写递归过程
        List<String> lefts = binaryTreePaths(root.left);
        for(String s:lefts){
            res.add(String.valueOf(root.val)+"->"+s);
        }
        List<String> rights = binaryTreePaths(root.right);
        for(String s:rights){
            res.add(String.valueOf(root.val)+"->"+s);
        }

        return res;
    }
}
