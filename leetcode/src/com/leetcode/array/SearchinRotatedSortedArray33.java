package com.leetcode.array;

/**
 * @author zlCalma
 * @date 2018/12/31 12:52.
 */
public class SearchinRotatedSortedArray33 {

    public int search(int[] nums, int target) {
        int high = nums.length-1;
        int low = 0;
        int mid = 0;
        while(low <= high){
            mid = (low + high)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[low] <= nums[mid]){
                if(nums[low]<=target && target<=nums[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else{
                if(nums[mid] <= target && target <= nums[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchinRotatedSortedArray33 s = new SearchinRotatedSortedArray33();
        int[] num = {4,5,6,7,0,1,2};
        System.out.println(s.search(num,0));
    }
}
