package com.zl.Tree;

import java.util.TreeMap;

/**
 * @author zlCalma
 * @date 2019/1/19 22:13.
 */
public class Trie {

    private class Node {

        public boolean isWord;//判断当前字符是否为一个单词的结尾
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

        private Node root;
        private int size;

        public Trie(){
            root = new Node();
            size = 0;
        }

        //获取Trie中的存储的单词数量
        public int getSize(){
            return size;
        }

        //向Trie中的存储新的单词
        public void add(String word){

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

        //Trie树中是否包含某个单词
        public boolean contains(String word){
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
        //Trie树中是否包含某个前缀
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
