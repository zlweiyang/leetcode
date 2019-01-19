package com.zl;

import com.zl.sortrank.BubbleSort;
import com.zl.sortrank.HeapSort;
import com.zl.sortrank.Test;

import java.util.Arrays;

/**
 * @author zlCalma
 * @date 2018/11/9 21:58.
 */
public class Sort {

    public static void swap(int[] arr, int i, int j) {
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int[] array = {1,3,2,5,7,8,6,4};
        int[] arr= {2,5,3,0,2,3,0,3};
        //System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(arr));
        //BubbleSort.bubbleSort(array);
        //BubbleSort.optimizeBubble(array);
        //InsertSort.insertSort(array);
        //SelectSort.selectSort(array);
        //QuickSort.sort(array);
        //ShellSort.sort(array);
        //MergeSort.sort(array);
        //Sort.InsertSort(array);
        //Sort.InsertSort(array);
        //Sort.shellSort(array);
        //Sort.mergeSort(array);
        //Sort.quickSort(array);
        //Sort.countingSort(arr);
        Sort.heapSort(array);
        //System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array));
    }

    //冒泡排序
    public static void bubbleSort(int [] arr){
         boolean flag = false;//优化冒泡排序算法，如果不发生交换则停止冒泡
        for(int i=0;i<arr.length;i++){
            for(int j = 0;j<arr.length-1-i;j++) {
                if (arr[j] > arr[j + 1]) {
                    Sort.swap(arr, j, j + 1);
                    flag = true;
                }
            }
            if(!flag){
                break;//已排好序，提前退出
            }
        }
    }

    //插入排序
    public static void insertSort(int[] arr){
        //初始的第一个元素已经排序，所以从下标为元素开始
        for(int i=1;i<arr.length;i++){
            int value = arr[i];//取每一个未排序元素并用value保存
            int j = i-1;
            for(;j>=0;j--){//从已排序的最后一个元素开始比较
                if(value < arr[j]){
                    arr[j+1] = arr[j];//向后移动数据
                }else{
                    break;//找到插入位置，跳出循环
                }
            }
            arr[j+1] = value;
        }
    }

    //选择排序
    public static void selectSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int minindex = i;//每趟遍历之前最小值下标记性保存
            int j = i+1;//在后面未排序中查找最小的
            for(;j<arr.length;j++){
                if(arr[j] < arr[minindex]){
                    minindex = j;//记录最小值下标
                }
            }
            Sort.swap(arr,i,j);
        }
    }

    //希尔排序
    public static void shellSort(int[] arr){
        int i,j,gap;
        for (gap = arr.length/2;gap>0;gap/=2){
            for(i=gap;i<arr.length;i++){
                for(j = i-gap;j>=0 && arr[j] > arr[j+gap];j -= gap){
                    Test.swap(arr,j,j+gap);
                }
            }
        }
    }
   /*********************************************************************/
    //归并算法start
    public static void mergeSort(int[] arr){
        //调用一个递归辅助函数
        mergeSorthelper(arr,0,arr.length-1);
    }

    //递归分而辅助函数
    public static void mergeSorthelper(int[] arr,int left,int right){
        //首先指定递归终止条件
        if (left >= right){
            return;
        }
        int mid = left + (right-left)/2;
        mergeSorthelper(arr,left,mid);
        mergeSorthelper(arr,mid+1,right);

        merge(arr,left,mid,right);
    }
    //定义治之合并函数
    public static void merge(int[]arr,int left,int mid,int right){
        int i = left;//左半部起点
        int j = mid+1;//右半部起点
        int k = 0;//初始变量用于临时数组下标
        int[] temp = new int[right-left+1];
        //将两部分元素进行比较
        while(i<=mid && j<=right){
            //等号保证稳定性
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }
        //退出while循环，查看那部分还有剩余元素，假定左半部分有
        int start = i;
        int end = mid;
        //如果是右半部分有则更新起止元素
        if(j <= right){
            start = j;
            end = right;
        }

        //将剩余元素放入临时数组等号不可忽略
        while (start <= end){
            temp[k++] = arr[start++];
        }
        //将临时数组中的元素返回给原数组arr，因为初始right = arr.length-1，所以必须加入等号
        for(i=0;i<=right - left;i++){
            //这里犯了一个小错误,必须为left+i，因为随着递归的进行右半部分并不全是是从0开始
            arr[left + i] = temp[i];
        }
    }

    //归并算法end
   /************************************************************************************/

   //快速排序start
   /**************************************************************************************/

   public static void quickSort(int[] arr){
       quickSorthelper(arr,0,arr.length-1);
   }

   //定义快速排序辅助函数进行递归
    public static void quickSorthelper(int[]arr,int left,int right){
       if(left >= right){
           return;
       }
        int p = partition(arr,left,right);//得到分区点
        quickSorthelper(arr,left,p-1);//左半部分递归
        quickSorthelper(arr,p+1,right);
    }
    //定义分片函数partiiton
    public static int partition(int[]arr,int left,int right){
        int i = left ;//左哨兵
        int j = right;//右哨兵
        int pvoit = arr[right];//选择最后的元素为基准

        //这种找分片点的方法不太好
//        for(int j = left;j<right;j++){
//            if(arr[j] < pvoit) {
//                Sort.swap(arr, i, j);
//                i++;
//            }
//        }
//        Sort.swap(arr,i,right);
//        return i;
        //这样更加容易看懂
        while (i != j){
            if(arr[i] < pvoit){
                i++;
            }
            else if(arr[j] > pvoit){
                j--;
            }else {
                 Sort.swap(arr,i,j);
                 i++;
            }
        }
        Sort.swap(arr,i,right);
        return i;
    }

   //快速排序
   /*******************************************************************************/

   //计数排序

    public static void countingSort(int []arr){
        if(arr.length < 1){
            return ;
        }

        //找出数组中最大数值

        int max = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }

        //根据max申请一个大小为max+1的桶
        int[] count = new int[max+1];
        //初始化为0
        for(int i=0;i<max+1;i++){
            count[i] = 0;
        }

        //记录每个元素的个数

        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }

        //对count数组的元素顺序求和
        for (int i=1;i<max+1;i++){
            count[i] = count[i-1] + count[i];
        }

        //新建临时数组存放排序结果
        int[] rank = new int[arr.length];
        //因为count数组是累加计数，所以从后往前遍历数组arr
        for(int i=arr.length-1;i>=0;i--){
            int index = count[arr[i]] -1;//arr[i]在排序数组中的下标
            rank[index] = arr[i];
            count[arr[i]]--;//排序一个就减少一个
        }

        //将排好序的元素放回arr数组
        for(int i=0;i<arr.length;i++){
            arr[i] = rank[i];
        }
    }

    //堆排序(最大堆)

    public static void heapSort(int[] arr){

        //将数组构建为大顶堆
        for(int i= arr.length/2-1;i>=0;i--){

            //从第一个非叶子节点开始调整
            adjustHeap(arr,i,arr.length);
        }
        //交换堆顶元素并调整对结构
        for(int i=arr.length-1;i>0;i--){
            swap(arr,0,i);//最大元素始终在下标为0处。
            adjustHeap(arr,0,i);
        }
    }

    /**
     *
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int [] arr,int i,int length){

        int temp = arr[i];//先取出当前元素
        for(int k = i*2+1;k<length;k = k*2+1){//从i节点的左子节点开始
            if(k+1<length && arr[k]<arr[k+1]){
                k++;
            }
            if(arr[k] > temp){//如果子节点大于父节点
                arr[i] = arr[k];//子节点直接赋值给父节点
                i = k;//父节点的索引变为子节点的索引
            }else{
                break;
            }
        }
        arr[i] = temp;//将元素放到最终的位置

    }


}
