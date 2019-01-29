package com.leetcode.array;

/**
 * @author zlCalma
 * @date 2019/1/23 23:17.
 */
public class FindtheDuplicateNumber287 {

    public int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[nums[0]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }

    public static void main(String[] args) {
        FindtheDuplicateNumber287 findtheDuplicateNumber287 = new FindtheDuplicateNumber287();
        int []arr  = {1,3,4,2,2};
        System.out.println(findtheDuplicateNumber287.findDuplicate(arr));
    }
}


