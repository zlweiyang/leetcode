package com.leetcode.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author zlCalma
 * @date 2019/1/27 20:24.
 */
public class TopKFrequentElements347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<Integer>();
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            Integer value = map.get(nums[i]);
            map.put(nums[i],(value == null? 0:value)+1);
        }
        List<Integer>[] bucket = new List[nums.length+1];
        for(int key:map.keySet()){
            int count = map.get(key);//获取key对应的value，也就是数据的频数
            if(bucket[count]==null){
                bucket[count]=new ArrayList<Integer>();
            }
            bucket[count].add(key);//频数对应的key存在桶中
        }
        for(int i=nums.length;i>0;i--){
            if(bucket[i]!=null && res.size()<k){
                res.addAll(bucket[i]);
            }
        }
        return res;
    }
}
