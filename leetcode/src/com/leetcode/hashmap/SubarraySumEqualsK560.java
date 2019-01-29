package com.leetcode.hashmap;

import java.util.HashMap;

/**
 * @author zlCalma
 * @date 2019/1/2 17:56.
 */
public class SubarraySumEqualsK560 {

    public int subarraySum(int[] nums, int k) {

//         int sum=0,res=0;
//         Map<Integer,Integer> preSum = new HashMap<>();
//         preSum.put(0,1);

//         for(int i=0;i<nums.length;i++){
//             sum += nums[i];
//             if(preSum.containsKey(sum-k)){
//                 res += preSum.get(sum-k);
//             }

//             preSum.put(sum,preSum.getOrDefault(sum,0)+1);
//         }
//         return res;

        int n = nums.length;
        HashMap<Integer, Integer> sumToFreq = new HashMap<>();
        //build a base case
        sumToFreq.put(0, 1);
        int sum = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sumToFreq.containsKey(sum - k)) {
                result += sumToFreq.get(sum - k);
            }
            if (sumToFreq.containsKey(sum)) {
                sumToFreq.put(sum, sumToFreq.get(sum) + 1);
            } else {
                sumToFreq.put(sum, 1);
            }
        }
        return result;
    }

}
