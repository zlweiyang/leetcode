package com.leetcode;

/**
 * @author zlCalma
 * @date 2019/1/2 23:22.
 */
public class RotateImage48 {
    public void rotate(int[][] matrix) {

        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix.length;j++){
                swap(matrix,i,j,j,i);
            }
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length/2;j++){
                swap(matrix,i,j,i,matrix.length-1-j);
            }
        }
    }

    public void swap(int[][]matrix,int x1,int y1,int x2,int y2){
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }
}
