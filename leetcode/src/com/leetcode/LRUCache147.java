package com.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zlCalma
 * @date 2019/1/11 16:44.
 */
public class LRUCache147 {

    private final int capacity;
    private Map<Integer,Integer> map;

    public LRUCache147(int capacity){
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }
    public int get(int key){
        Integer val = map.get(key);
        map.remove(key);
        map.put(key,val);
        return val;
    }

    public void put(int key,int value){
        map.remove(key);
        map.put(key,value);
        if(map.size()> capacity){
            Integer k = map.keySet().iterator().next();
            map.remove(k);
        }
    }

    public static void main(String[] args) {
        LRUCache147 lru = new LRUCache147(4);
        lru.put(1,1);
        lru.put(2,2);
        lru.put(3,3);
        lru.put(4,4);
        lru.put(5,5);
    }
}
