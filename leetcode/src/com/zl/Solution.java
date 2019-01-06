package com.zl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
        public void sortColors(int[] nums) {

            int [] count = new int[3];
            //int [] res = new int[nums.length];
            for(int i=0;i<nums.length;i++){
                count[nums[i]]++;
            }
            int k=0;
            for(int i=0;i<3;i++){
                for(int j=0;j<count[i];i++){
                    nums[k] = i;
                    k++;
                }
            }

        }
    public static void main(String[] args) {
//        Solution s = new Solution();
//        //System.out.println(s.("{[]}"));
//        int[] nums = {0,1,2,1,2,0};
//        s.sortColors(nums);

        int demo = 4;
        System.out.println(0<<1);
    }
}