package com.sunyi.algorithm;

/**
 * <p>
 * 两个有序数组取出合并后的中位数
 * </p>
 *
 * @author sunyi
 * @date 20191226
 */
public class TwoArrayMiddleNumber {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] allNumber = new int[nums1.length + nums2.length];
        int j = 0, k = 0;
        for (int i = 0; i < allNumber.length; i++) {
            if (j >= nums1.length && k < nums2.length) {
                allNumber[i] = nums2[k];
                k++;
            }
            if (k >= nums2.length && j < nums1.length) {
                allNumber[i] = nums1[j];
                j++;
            }
            if (j < nums1.length && k < nums2.length) {
                if (nums1[j] < nums2[k]) {
                    allNumber[i] = nums1[j];
                    j++;
                } else {
                    allNumber[i] = nums2[k];
                    k++;
                }
            }
        }
        return (nums1.length + nums2.length) % 2 != 0 ? allNumber[allNumber.length / 2]
                : (allNumber[allNumber.length / 2] + allNumber[allNumber.length / 2 - 1]) / 2.0;
    }

    public static void main(String[] args) {
        System.out.println(new TwoArrayMiddleNumber().findMedianSortedArrays(new int[]{}, new int[]{1}));
    }
}
