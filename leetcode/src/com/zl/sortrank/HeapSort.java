package com.zl.sortrank;

public class HeapSort {

    public static void sort(int[] arr) {
        MaxHeap h = new MaxHeap();
        h.init(arr);
        for(int i = 0;i<arr.length;i++) {
            h.remove();
        }
        System.arraycopy(h.queue, 1, arr, 0, arr.length);;
    }

    private static class MaxHeap{
        void init(int[] arr) {
            this.queue = new int[arr.length +1];
            for(int i=0;i<arr.length;i++) {
                queue[++size] = arr[i];
                fixUp(size);
            }
        }
        private int size = 0;
        private int[] queue;

        public int get() {
            return queue[1];
        }

        private void remove() {
            Test.swap(queue, 1, size--);
            fixDown(1);
        }

        private void fixDown(int k) {
            int j;
            while((j = k << 1) <= size) {
                if(j < size && queue[j] < queue[j+1]) {
                    j++;
                }
                if(queue[k] > queue[j]) {
                    break;
                }
                Test.swap(queue, j, k);
                k = j;
            }
        }

        private void fixUp(int k) {
            while(k >1) {
                int j = k >> 1;
                if(queue[j] > queue[k]) {
                    break;
                }
                Test.swap(queue, j, k);
                k = j;
            }
        }
    }

}
