package com.zl.sortrank;
/**
 * 无论好坏时间复杂度为nlgn
 * 空间复杂度为O(n)
 */
public class MergeSort {

    public static void sort(int[] arr){
        int []temp = new int[arr.length];
        sort(arr,0,arr.length -1,temp);

    }

    private static void sort(int[] arr,int left,int right,int[] temp){
        if(left < right){
            int mid = (left + right)/2;
            sort(arr,left,mid,temp);
            sort(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);
        }
    }

    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;
        int j = mid+1;
        int t = 0;
        while(i<=mid && j<=right){
            if(arr[i] <= arr[j]){
                temp[t++] = arr[i++];
            }else{
                temp[t++] = arr[j++];
            }
        }
        while (i<=mid){
            temp[t++] = arr[i++];
        }
        while(j<=right){
            temp[t++] = arr[j++];
        }

        t=0;

        while(left <= right){
            arr[left++] = temp[t++];
        }
    }
}
