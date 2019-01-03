package com.zl.sortrank;

public class InsertSort {
    /**
     * 最好情况O(n)
     * 最坏情况O(n^2)
     * 简单稳定
     * @param arr
     */
    public static void insertSort(int[]arr){
        for(int i=1;i<arr.length;i++){
            for (int j=i;(j>0)&(arr[j]<arr[j-1]);j--){
                Test.swap(arr,j,j-1);
            }
        }
    }
}
