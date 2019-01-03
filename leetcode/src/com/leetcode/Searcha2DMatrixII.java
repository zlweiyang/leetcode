package com.leetcode;

/**
 * @author zlCalma
 * @date 2019/1/2 23:14.
 */
public class Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix==null || matrix.length==0){
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int down = 0;
        int left = col-1;
        while(left>=0 && down<= row-1){
            if(matrix[down][left]==target){
                return true;
            }
            if(matrix[down][left]>target){
                left--;
            }else{
                down++;
            }
        }
        return false;
    }
}
