package com.sunyi.algorithm.heap;

/**
 * <p>
 * 最大堆
 * </p>
 *
 * @author sunyi
 * @date 20200615
 */
public class MaxHeap {

    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "_");
        }
    }

    public void heapSort(int arr[]) {
        buildHeap(arr);
        int temp;
        for (int i = arr.length - 1; i >= 1; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr, i, 0);
        }
    }

    public void buildHeap(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }
    }

    public void heapify(int[] arr, int to, int i) {
        int largest = i;
        int left = left(i);
        int right = right(i);
        if (left < to && arr[left] >= arr[largest]) {
            largest = left;
        }
        if (right < to && arr[right] >= arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, to, largest);
        }
    }

    public int left(int i) {
        return 2 * (i + 1) - 1;
    }

    public int right(int i) {
        return 2 * (i + 1);
    }
}
