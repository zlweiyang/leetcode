package com.leetcode.array;

/**
 * @author zlCalma
 * @date 2018/12/31 16:14.
 * 确定一个最小mn和一个最大mx
 * 在mn*nums[i],nums[i]*mx,nums[i]之间转化
 */
public class MaximumProductSubarray152 {
    class Solution {
        public int maxProduct(int[] nums) {

            int min = nums[0];
            int max = nums[0];
            int res = nums[0];

            for(int i=1;i<nums.length;i++){
                int mx = max,mn = min;
                max = Math.max(nums[i],Math.max(mx*nums[i],mn*nums[i]));
                min = Math.min(nums[i],Math.min(mx*nums[i],mn*nums[i]));
                res = Math.max(max,res);
            }
            return res;
        }
    }
}
