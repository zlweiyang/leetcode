package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zlCalma
 * @date 2019/1/27 22:51.
 */
public class SpiralMatrix54 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0){
            return res;
        }
        int start = 0;
        int row = matrix.length-1;
        int col = matrix[0].length-1;
        while(start<row && start<col){
            helper(start,row,col,matrix);
            start++;
            col--;
            row--;
        }
        if(start == col){
            for(int i=start;i<=row;i++){
                res.add(matrix[i][start]);
            }
        }
        else if(start == row){
            for(int i=start;i<=col;i++){
                res.add(matrix[start][i]);
            }
        }
        return res;
    }

    public void helper(int start,int row,int col,int[][] mat){
        for(int i=start;i<=col;i++){
            res.add(mat[start][i]);
        }
        for(int i=start+1;i<=row;i++){
            res.add(mat[i][col]);
        }
        for(int i=col-1;i>=start;i--){
            res.add(mat[row][i]);
        }
        for(int i=row-1;i>start;i--){
            res.add(mat[i][start]);
        }
    }
}
