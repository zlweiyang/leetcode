package com.zl.sortrank;

public class ShellSort {

    public static void sort(int[] arr){
        for(int i=arr.length/2;i>2;i/=2){
            for(int j=0;j<i;j++){
                shellSort(arr,j,i);
            }
        }
        shellSort(arr,0,1);
    }

    public static void shellSort(int[] arr,int start,int inc){
        for(int i = start + inc ;i<arr.length;i = i+inc){
            for(int j = i;(j>=inc)&&(arr[j]< arr[j - inc]); j -= inc){
                Test.swap(arr,j,j-inc);
            }
        }
    }
}
