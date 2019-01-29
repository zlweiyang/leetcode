package com.leetcode.array;

/**
 * @author zlCalma
 * @date 2019/1/2 17:03.
 */
public class TrappingRainWater42 {
    public int trap(int[] height) {
        int left=0;
        int right = height.length-1;
        int minh = 0;
        int water = 0;
        while(left < right){
            minh = Math.max(minh,Math.min(height[left],height[right]));

            if(height[left]<height[right]){
                water += minh-height[left];
                left++;
            }else{
                water += minh - height[right];
                right--;
            }
        }
        return water;
    }
}
