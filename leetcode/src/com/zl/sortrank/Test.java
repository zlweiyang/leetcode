package com.zl.sortrank;

import java.util.Arrays;


public class Test {

    public static void main(String[] args){

        int[] array = {1,3,2,5,7,8,6,4};
        System.out.println(Arrays.toString(array));
        //BubbleSort.bubbleSort(array);
        //BubbleSort.optimizeBubble(array);
        //InsertSort.insertSort(array);
        //SelectSort.selectSort(array);
        //QuickSort.sort(array);
        //ShellSort.sort(array);
        //MergeSort.sort(array);
        HeapSort.sort(array);
        System.out.println(Arrays.toString(array));

    }

    public static void swap(int [] arr,int i,int j){
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
