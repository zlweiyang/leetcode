package com.zl.fourthree;

/**
 * @author zlCalma
 * @date 2018/12/25 17:27.
 */
public class BallInPackage {
    public int ballInPackage(int numsOfBags, int numsOfBalls)
    {
        int[][] dp = new int[numsOfBags][numsOfBalls + 1];
        //initialization
        for(int i = 0; i < numsOfBags; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i <= numsOfBalls; i++) {
            dp[0][i] = 1;
        }
        //calculate the dp matrix
        for(int i = 1; i < numsOfBags; i++) {
            for(int j = 1; j <= numsOfBalls; j++) {
                int nums = 0;
                for(int k = 0; k <= j; k++) {
                    nums += dp[i - 1][k];
                }
                dp[i][j] = nums;
            }
        }
        return dp[numsOfBags-1][numsOfBalls];
    }
    public int ballInPackage_Advanced(int numsOfBags, int numsOfBalls)
    {
        int[][] dp = new int[numsOfBags][numsOfBalls + 1];
        //initialization
        for(int i = 0; i < numsOfBags; i++) {
            dp[i][0] = 1;
        }
        dp[0][2] = 1; dp[0][3] = 1;
        //calculate the dp matrix
        for(int i = 1; i < numsOfBags; i++) {
            for(int j = 1; j <= numsOfBalls; j++) {
                if(j < 2) {
                    dp[i][j] += dp[i - 1][j];
                }
                else if(j == 2) {
                    dp[i][j] += dp[i - 1][j] + dp[i - 1][j - 2];
                }
                else if(j >= 3) {
                    dp[i][j] += dp[i - 1][j] + dp[i - 1][j - 2] + dp[i - 1][j - 3];
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[numsOfBags-1][numsOfBalls];
    }

    public static void main(String[] args) {
        BallInPackage b = new BallInPackage();
        System.out.println(b.ballInPackage(12, 20));
        System.out.println(b.ballInPackage_Advanced(12, 20));
    }
}
