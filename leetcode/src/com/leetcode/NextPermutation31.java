package com.leetcode;

/**
 * @author zlCalma
 * @date 2019/1/3 17:35.
 * 把握两点：1.将最大的向前移动一位
 * 2.如果是逆序，则完全转化为升序
 */
public class NextPermutation31 {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if(len==0||len==1){
            return;
        }
        int i=len-2;
        for(;i>=0;i--){
            if(nums[i]<nums[i+1]){
                break;
            }
        }
        int j=len-1;
        while(i!=-1&&i<j-1&&nums[j]<=nums[i]){
            j--;
        }
        if(i!=-1){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j]=temp;
        }
        for(i=i+1,j=len-1;i<j;i++,j--){
            int temp = nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
    }
}
