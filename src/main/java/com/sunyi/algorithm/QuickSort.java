package com.sunyi.algorithm;

/**
 * <p>
 * 快速排序
 * </p>
 *
 * @author sunyi
 * @date 20200509
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] originArray = {8, 2, 5, 4, 3, 6, 7, 1};
        sort(originArray, 0, originArray.length - 1);
        for (int temp : originArray
        ) {
            System.out.println(temp);
        }
    }

    public static void sort(int[] array, int p, int r) {
        if (p < r) {
            int x = array[r];
            int i = p - 1;
            for (int j = p; j <= r; j++) {
                if (array[j] <= x) {
                    ++i;
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            int temp = array[r];
            array[r] = array[i + 1];
            array[i + 1] = temp;
            sort(array, p, i - 1);
            sort(array, i + 1, r);
        }
        return;
    }
}
