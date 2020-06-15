package com.sunyi.algorithm;

/**
 * <p>
 * 选择排序
 * </p>
 *
 * @author sunyi
 * @date 20200508
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] targetArray = sort(new int[]{5, 3, 1, 2, 4});
        for (int i : targetArray) {
            System.out.println(i);
        }
    }

    public static int[] sort(int[] originArray) {
        int length = originArray.length;
        for (int i = 0; i < length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (originArray[j] > originArray[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = originArray[i];
                originArray[i] = originArray[min];
                originArray[min] = temp;
            }
        }
        return originArray;
    }
}
