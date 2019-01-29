package com.leetcode.dynamic;

/**
 * @author zlCalma
 * @date 2018/12/31 14:07.
 * 向右，向后递归遍历，关键是保留每一次遍历结果的最小值
 */
public class MinimumPathSum64 {

    public int minPathSum(int[][] grid) {

        Integer [][] mem = new Integer[grid.length][grid[0].length];
        return helper(mem,grid,0,0);
        //return mem[grid.length-1][grid[0].length-1];
    }

    public int helper(Integer[][] mem,int[][]grid,int i,int j){
        if(i==grid.length || j==grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(i==grid.length-1 && j==grid[0].length-1){
            return grid[i][j];
        }
        if(mem[i][j] == null){
            mem[i][j] = Math.min(helper(mem,grid,i+1,j),helper(mem,grid,i,j+1))+grid[i][j];
        }
        return mem[i][j];
    }
}
