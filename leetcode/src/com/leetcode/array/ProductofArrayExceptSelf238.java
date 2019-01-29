package com.leetcode.array;

/**
 * @author zlCalma
 * @date 2019/1/1 20:24.
 */
public class ProductofArrayExceptSelf238 {
    public int[] productExceptSelf(int[] nums) {
        int [] res = new int[nums.length];
        res[0] = 1;
        for(int i=1;i<nums.length;i++){
            res[i] = res[i-1]*nums[i-1];
        }
        int temp = 1;
        for(int i=nums.length-2;i>=0;i--){
            temp *= nums[i+1];
            res[i] *= temp;
        }
        return res;
    }
}
