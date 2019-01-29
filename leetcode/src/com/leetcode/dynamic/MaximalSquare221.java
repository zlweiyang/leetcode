package com.leetcode.dynamic;

/**
 * @author zlCalma
 * @date 2018/12/31 13:45.
 * 动态规划，以正方形右下角位置为依据
 * dp[i][j] = min(dp[i][j-1],dp[i-1][j],dp[i-1][j-1]);
 * 再求出最大边
 * 这种方法效率不太高，可以尝试一下深度优先搜索dfs+动态规划
 */
public class MaximalSquare221 {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int [row+1][col+1];
        int res = 0;
        for(int i=0;i<row;i++){
            if(matrix[i][0] == '1'){
                dp[i][0] = 1;res=1;
            }
        }
        for(int i=0;i<col;i++){
            if(matrix[0][i] == '1'){
                dp[0][i] = 1;res=1;
            }
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]))+1;
                }
                res = Math.max(res,dp[i][j]);
            }
        }
        return res*res;
    }
}
