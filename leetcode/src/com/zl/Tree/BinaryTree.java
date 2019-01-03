package com.zl.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    /**
     * 前序遍历
     * @param root
     */
    public void preOrder(BinaryTreeNode root){
        if (root!=null){
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    void inOrder(BinaryTreeNode root){
        if(root !=null){
            //System.out.println(root.getData());
            inOrder(root.left);
            System.out.println(root.data);
            inOrder(root.right);
        }
    }

    /**
     * 后序遍历
     * @param root
     */
    void postOrder(BinaryTreeNode root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data);
        }
    }
    /**
     * 层次遍历
     *
     */
    public void levelOrder(BinaryTreeNode root) {
        BinaryTreeNode temp;
        if(root == null){
            System.out.println("this is a empty tree");
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>() ;
        queue.offer(root);
        while(!queue.isEmpty()){
            temp = queue.poll();
            System.out.println(temp.data);
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if(temp.right != null){
                queue.offer(temp.right);
            }
        }
    }

    /***
     * 构建一棵二叉树
     */

    public BinaryTreeNode root;
    public void buildTree(int[] arr){
        for(int node:arr){
            insert(node);
        }
    }
    public void insert(int data){
        root = insert(root,data);
    }
    public BinaryTreeNode insert(BinaryTreeNode root,int data){
        if(root == null) {return new BinaryTreeNode(data);}
        if(root.data > data){
            root.left = insert(root.left,data);
        }
        else if(root.data < data){
            root.right = insert(root.right,data);
        }
        else{
            root.left = insert(root.left,data);
        }

        return root;
    }

    /**
     * 构建一颗二叉树
     */
    public void CreatTree(){

    }
}
