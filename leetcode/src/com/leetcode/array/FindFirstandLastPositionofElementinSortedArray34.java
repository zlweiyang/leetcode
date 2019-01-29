package com.leetcode.array;

/**
 * @author zlCalma
 * @date 2019/1/23 23:02.
 */
public class FindFirstandLastPositionofElementinSortedArray34 {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0||nums == null){
            return new int[]{-1,-1};
        }
        int start = findFirst(nums,target);
        if( start == -1){
            return new int[]{-1,-1};
        }
        return new int[]{start,findLast(nums,start,target)};
    }
    public int findFirst(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target){
                right = mid;
            }
            else if(nums[mid]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return nums[left] == target? left:-1;
    }
    public int findLast(int[] nums,int num,int target){
        int left = num;
        int right = nums.length-1;
        while(left < right){
            int mid = left + (right-left+1)/2;
            if(nums[mid]==target){
                left = mid;
            }
            else if(nums[mid]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return nums[left] == target? left:-1;
    }
}
