package com.leetcode.hashmap;

import java.util.*;

/**
 * @author zlCalma
 * @date 2019/1/25 23:02.
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
["ate","eat","tea"],
["nat","tan"],
["bat"]
]
 hashmap与list的一个较好的应用

 字符串处理除了数个数，也可以排序处理
 */
public class GroupAnagrams49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res =  new ArrayList<>();
        if(strs == null || strs.length==0){
            return res;
        }
        Map<String,Integer> map = new HashMap<String,Integer>();
        for(String str:strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String s = new String(arr);
            if(map.containsKey(s)){
                //这一步很关键，在已经存在的双重List中的List动态添加元素
                List<String> list = res.get(map.get(s));
                list.add(str);
            }else{
                List<String> tmp = new ArrayList<>();
                tmp.add(str);
                //key为排序后的元素，value为元素列表所在双重List中的下表位置，主要是为了
                //让后面同分异位词加入到对应的List中。
                map.put(s,res.size());
                res.add(tmp);
            }
        }
        return res;
    }
}
