package com.zl.Tree;

public class TestTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        //BinaryTreeNode node = new BinaryTreeNode();
        //BinaryTreeNode treeNode = new BinaryTreeNode();
        int[] arr = {1, 7, 3, 2, 5, 6, 4};


        //int len  = arr.length;
        tree.buildTree(arr);
        tree.inOrder(tree.root);
    }
}
