package com.zl.sortrank;

public class SelectSort {

    /**
     * 最坏时间复杂度和最佳时间复杂度都是O(n^2)
     * 不稳定、简单
     * @param arr
     */

    public static void selectSort(int[] arr){

        for(int i=0;i<arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
                if(arr[j]<arr[i])
                Test.swap(arr,i,j);
            }
        }
    }
}
