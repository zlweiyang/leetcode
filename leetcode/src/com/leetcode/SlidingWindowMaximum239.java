package com.leetcode;

/**
 * @author zlCalma
 * @date 2019/1/2 17:34.
 *
 * 效率较差
 */
public class SlidingWindowMaximum239 {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int len = nums.length;
        int[] res = new int[len-k+1];
        if(len==0){
            return new int[0];
        }
        int j=0;
        for(int i=0;i<=nums.length-k;i++){
            res[j] = getMax(nums,i,i+k-1);
            j++;
        }

        return res;
    }

    public int getMax(int[] nums,int start,int end){
        int max = Integer.MIN_VALUE;
        for(int i=start;i<=end;i++){
            if(nums[i]>=max){
                max = nums[i];
            }
        }
        return max;
    }
}
