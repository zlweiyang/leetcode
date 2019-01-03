package com.leetcode;

/**
 * @author zlCalma
 * @date 2019/1/1 18:25.
 */
public class PartitionEqualSubsetSum416 {

    public boolean canPartition(int[] nums) {

        int sum=0;
        for(int num:nums){
            sum += num;
        }

        if(sum%2 != 0){
            return false;
        }

        return helper(nums,sum/2,nums.length-1);
    }

    public boolean helper(int[] nums,int targetsum,int start){

        if(targetsum == 0){
            return true;
        }
        else if(targetsum > 0 && start>=0){
            for(int i=start;i>=0;i--){
                if(targetsum - nums[i] < 0){
                    break;
                }

                if(helper(nums,targetsum-nums[i],i-1)){
                    return true;
                }
            }
        }

        return false;
    }

}
