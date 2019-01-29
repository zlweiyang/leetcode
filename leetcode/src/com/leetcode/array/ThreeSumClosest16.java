package com.leetcode.array;

import java.util.Arrays;

/**
 * @author zlCalma
 * @date 2019/1/27 21:35.
 */
public class ThreeSumClosest16 {
    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[2];
        //int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int tmp = nums[i] + nums[left] + nums[right];
                if (Math.abs(tmp - target) < Math.abs(res - target)) {
                    res = tmp;
                }
                if (tmp > target) {
                    right--;
                } else if (tmp < target) {
                    left++;
                } else {
                    return target;
                }
            }

        }
        return res;
    }
}
