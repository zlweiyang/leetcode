package com.leetcode.dfs;

/**
 * @author zlCalma
 * @date 2019/1/3 10:37.
 * DFS
 * 还有BFS的方法
 */
public class NumberofIslands200 {
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    dfsFill(grid,i,j);
                    count++;
                }
            }
        }

        return count;
    }
    public void dfsFill(char[][]grid,int i,int j){
        if(i>=0 && j>=0 && i<grid.length&&j<grid[0].length&&grid[i][j]=='1'){
            grid[i][j]='0';
            dfsFill(grid,i+1,j);
            dfsFill(grid,i,j+1);
            dfsFill(grid,i-1,j);
            dfsFill(grid,i,j-1);
        }
    }
}
