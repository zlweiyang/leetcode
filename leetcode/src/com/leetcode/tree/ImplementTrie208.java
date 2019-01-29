package com.leetcode.tree;

import java.util.TreeMap;

/**
 * @author zlCalma
 * @date 2019/1/25 23:35.
 *
 * 注意Node以及字符处理
 */
public class ImplementTrie208 {
    private class Node{

        private boolean isWord;//当前节点为止是否为单词
        private TreeMap<Character,Node> next;//下一个节点
        public Node (boolean isWord){
            this.isWord  = isWord;
            next = new TreeMap<>();
        }
        public Node(){
            this(false);
        }
    }
    private Node root;
    private int size;
    /** Initialize your data structure here. */
    public ImplementTrie208() {
        root = new Node();
        size =  0 ;
    }
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null){
            return;
        }
        Node cur = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(cur.next.get(c) == null){
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c);
        }
        if(!cur.isWord){
            cur.isWord = true;
            size++;
        }
    }
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;

    }
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = root;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }
}
