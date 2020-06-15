package com.sunyi.algorithm;

/**
 * <p>
 * 二分查找法
 * </p>
 *
 * @author sunyi
 * @date 20200508
 */
public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 2, 3, 4, 5}, 4));
    }

    public static int search(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target > array[mid]) {
                low = mid + 1;
            } else if (target < array[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return 0;
    }
}
