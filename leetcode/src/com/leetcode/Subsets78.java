package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zlCalma
 * @date 2019/1/2 18:06.
 *dfs效果更好
 */
public class Subsets78 {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        helper(nums,res,new ArrayList<Integer>(),0);
        return res;

    }

    public void helper(int[]nums,List<List<Integer>> res,ArrayList<Integer> temp,int index){
        if(index == nums.length){
            res.add(new ArrayList(temp));
        }else{
            temp.add(nums[index]);
            helper(nums,res,temp,index+1);
            temp.remove(temp.size()-1);
            helper(nums,res,temp,index+1);
        }
    }
}
