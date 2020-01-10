package com.coolslow.leetcode.top100;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *  - 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 *  - 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 */
public class NO88_MergeTwoSortedArray {

    /**
     * 方法一:
     *
     * 最朴素的解法就是将两个数组合并之后再排序，该算法的时间复杂度交叉，为O(n+m)log(n+m)。
     * 这是由于这种方法没有利用两个数组本身已经有序这一点。
     *
     * System.arraycopy(
     *  Object src,  //源数组
     *  int srcPos,  //源数组的起始位置
     *  Object dest, //目标数组
     *  int destPos, //目标数组的起始位置
     *  int length // 拷贝长度
     * )
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void mergeAndSort(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 方法二:
     *
     * 一般而言，对于有序数组可以通过双指针法达到O(m + n)的时间复杂度
     * 最直接的算法实现是将指 p1 置为 nums1 的开头， p2 为nums2的开头，在每一步将最小值放入输入数组中。
     * 由于 nums1 是用于输出的数组，需要将 nums1 中的前m个元素放在其他地方，因此需要O(m)的空间复杂度。
     *
     * 时间复杂度: O(n + m)O(n+m)
     * 空间复杂度 : O(m)O(m)
     *
     * System.arraycopy(
     *  Object src,  //源数组
     *  int srcPos,  //源数组的起始位置
     *  Object dest, //目标数组
     *  int destPos, //目标数组的起始位置
     *  int length // 拷贝长度
     * )
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void mergeWithTwoPointers(int[] nums1, int m, int[] nums2, int n) {
        // 拷贝nums1
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        // 设置 nums1_copy 和 nums2对应的两个指针
        int p1 = 0;
        int p2 = 0;

        // 设置nums1数组的指针指向数组的第一个元素
        int p = 0;

        // 比较nums1_copy与nums2两个数组中的元素，将最小的元素添加到nums1中
        while((p1 < m) && (p2 <n)) {
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
        }

        if(p1 < m) {
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if(p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
    }
}
