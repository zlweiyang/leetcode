package com.leetcode.dynamic;

/**
 * @author zlCalma
 * @date 2019/1/27 20:27.
 */
public class UniqueBinarySearchTrees96 {
    public int numTrees(int n) {
        if(n < 1){
            return  0;
        }
        int [] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            //int sum = 0;
            for(int j=0;j<i;j++){
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
}
