package com.leetcode;

/**
 * @author zlCalma
 * @date 2019/1/2 17:18.
 */
public class ShortestUnsortedContinuousSubarray581 {

    public int findUnsortedSubarray(int[] nums) {

        int len = nums.length;
        int begin=-1,end=-2,min=nums[len-1],max=nums[0];
        for(int i=1;i<len;i++){
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[len-1-i]);
            if(nums[i]<max){
                end=i;
            }
            if(nums[len-1-i]>min){
                begin=len-1-i;
            }
        }
        return end-begin+1;
    }
}
