package com.zl.fourthree;

import java.util.Scanner;

/**
 * @author zlCalma
 * @date 2018/12/25 17:12.
 */
public class LookingforChange {


    public static int[] coins = {1,5,10,20,50,100};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] dp = new long[n+1];
        for(int i=1;i<coins.length;i++) {
            for (int j = coins[i - 1]; j <= n; j++) {
                if (j == coins[i - 1]) {
                    dp[j] += 1;
                } else {
                    dp[j] += dp[j - coins[i - 1]];
                }
            }
        }
        System.out.println(dp[n]);
    }
}
