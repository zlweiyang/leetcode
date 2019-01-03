package com.leetcode;

/**
 * @author zlCalma
 * @date 2019/1/2 18:16.
 */
public class TargetSum494 {
    public int findTargetSumWays(int[] nums, int S) {
        int[] res = new int[1];
        res[0]=0;
        dfs(nums,0,0,res,S);
        return res[0];
    }

    public void dfs(int[] nums,int target,int index,int[] res,int S){
        if(index == nums.length){
            if(target==S){
                res[0]++;
            }
        }else{
            dfs(nums,target-nums[index],index+1,res,S);
            dfs(nums,target+nums[index],index+1,res,S);
        }
    }
}
