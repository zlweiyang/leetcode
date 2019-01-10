package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author zlCalma
 * @date 2019/1/9 23:35.、
 *
 * 中序遍历
 */
public class KthSmallestElementinaBST {

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
