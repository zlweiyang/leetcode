package com.zl.sortrank;

/**
 * 平均时间复杂度O(nlgn)
 * 最坏时间复杂度O(n^2)
 * 最好时间复杂度O(nlgn)
 * 不稳定
 */
public class QuickSort {

    public static int partition(int[] arr,int l,int r,int pivot){
        do{
            while(arr[++l] < pivot){};
            while((r != 0) && arr[--r] > pivot){};
            Test.swap(arr,l,r);
        }while(l<r);
        Test.swap(arr,l,r);
        return l;
    }

    public static void quickSort(int [] arr,int i,int j){
        int pivotIndex = (i+j)/2;
        Test.swap(arr,pivotIndex,j);

        int k = partition(arr,i-1,j,arr[j]);
        Test.swap(arr,k,j);
        if((k - i) > 1) {
            quickSort(arr, i, k - 1);
        }
        if((j - k) >1) {
            quickSort(arr, k + 1, j);
        }
    }

    public static void sort(int[] arr){
        quickSort(arr,0,arr.length -1 );
    }
}
