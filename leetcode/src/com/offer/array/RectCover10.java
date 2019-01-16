package com.offer.array;

/**
 * @author zlCalma
 * @date 2019/1/16 23:41.
 */
public class RectCover10 {

    public int RectCover(int target) {
        if(target < 1){
            return 0;
        }
        int[] dp = new int[target+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=target;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[target];
    }

    public static void main(String[] args) {
        RectCover10 r = new RectCover10();
        System.out.println(r.RectCover(5));
    }
}
