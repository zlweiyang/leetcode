package com.leetcode;

/**
 * @author zlCalma
 * @date 2019/1/1 20:24.
 */
public class ProductofArrayExceptSelf238 {

    public int[] productExceptSelf(int[] nums) {

        int [] res = new int[nums.length];
        for(int i=0;i<res.length;i++){
            res[i]=1;
        }
        for(int i=1;i<nums.length;i++){
            res[i]=res[i-1]*nums[i-1];
        }
        for(int i=res.length-2;i>=0;i--){
            res[i]*=nums[i+1];
            nums[i]*=nums[i+1];
        }

        return res;
    }
}
