package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zlCalma
 * @date 2019/1/2 16:30.
 */
public class SerializeandDeserializeBinaryTree297 {

    private static final String spliter = ",";
    private static final String NN = "X";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        buildString(root,sb);
        return sb.toString();
    }

    public void buildString(TreeNode node,StringBuilder sb){
        if(node == null){
            sb.append(NN).append(spliter);
        }else{
            sb.append(node.val).append(spliter);
            buildString(node.left,sb);
            buildString(node.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(queue);
    }

    public TreeNode buildTree(Queue<String>queue){
        String val = queue.remove();
        if(val.equals(NN)){
            return null;
        }else{
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(queue);
            node.right=buildTree(queue);
            return node;
        }
    }

}
