package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zlCalma
 * @date 2019/1/27 20:17.
 */
public class Permutations46 {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0){
            return res;
        }
        used = new boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            used[i] = false;
        }
        LinkedList<Integer> list = new LinkedList<>();
        helper(nums,0,list);
        return res;
    }
    public void helper(int[] nums,int index,LinkedList<Integer> list){
        if(index == nums.length){
            res.add((LinkedList<Integer>) list.clone());
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                list.addLast(nums[i]);
                used[i] = true;
                helper(nums,index+1,list);
                list.removeLast();
                used[i] = false;
            }
        }
        return ;
    }
}
