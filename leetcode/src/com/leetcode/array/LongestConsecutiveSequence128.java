package com.leetcode.array;

import java.util.Arrays;

/**
 * @author zlCalma
 * @date 2019/1/27 20:06.
 */
public class LongestConsecutiveSequence128 {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        Arrays.sort(nums);
        int count = 1;
        int max = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]-1 == nums[i-1]){
                count++;
            }
            else if(nums[i] == nums[i-1]){
                continue;
            }
            else{
                max = Math.max(count,max);
                count = 1;
            }
        }
        return Math.max(max,count);
    }
}
