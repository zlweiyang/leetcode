package com.leetcode.array;

/**
 * @author zlCalma
 * @date 2019/1/27 21:03.
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

示例:

输入: 3
输出:
[
[ 1, 2, 3 ],
[ 8, 9, 4 ],
[ 7, 6, 5 ]
]
 */
public class SpiralMatrixII59 {
    int num = 1;
    public int[][] generateMatrix(int n) {
        int start = 0;
        int index = n-1;
        int[][] res = new int[n][n];
        while(start<index){
            helper(start,index,res);
            start++;
            index--;
        }
        if(index==start){
            res[index][index] = num;
        }
        return res;
    }
    public void helper(int start,int index,int[][] mat){
        for(int i=start;i<=index;i++){
            mat[start][i]=num++;
        }
        for(int i=start+1;i<=index;i++){
            mat[i][index]=num++;
        }
        for(int i=index-1;i>=start;i--){
            mat[index][i] = num++;
        }
        for(int i=index-1;i>start;i--){
            mat[i][start]=num++;
        }
    }
}
