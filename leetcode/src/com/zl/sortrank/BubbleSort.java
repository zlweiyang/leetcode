package com.zl.sortrank;

public class BubbleSort {
    /**
     * @param arr
     * 普通冒泡排序时间O(n^2)
     * 简单稳定
     */
    public static void bubbleSort(int[]arr){

        for(int i=1;i<arr.length;i++){
            for(int j=0;j<arr.length-1;j++){
                if(arr[j] > arr[j+1]){
                    Test.swap(arr,j,j+1);
                }
            }
        }

    }

    /**
     *
     * 改进后的冒泡排序最佳时间复杂度为O（n)即全部为正序时
     * @param arr
     */
    public static void optimizeBubble(int[] arr){

        boolean isSwap = false;

        for(int i=1;i<arr.length;i++){
            for(int j=0;j<arr.length-1;j++){
                if(arr[j] > arr[j+1]){
                    Test.swap(arr,j,j+1);
                    isSwap = true;
                }
            }
            if(!isSwap){
                break;
            }
        }
    }
}
