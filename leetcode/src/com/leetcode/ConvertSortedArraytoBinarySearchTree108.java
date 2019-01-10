package com.leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class ConvertSortedArraytoBinarySearchTree108 {
    public TreeNode sortedArrayToBST(int[] nums) {

        return CreateTree(nums,0,nums.length-1);

    }

    TreeNode CreateTree(int[] nums,int l,int r ){
        if(l>r) return null;
        int mid = (l+r+1)/2;
        TreeNode node = new TreeNode(0);

        node.val = nums[mid];
        node.left = CreateTree(nums,l,mid-1);
        node.right = CreateTree(nums,mid+1,r);
        return node;


    }
}
