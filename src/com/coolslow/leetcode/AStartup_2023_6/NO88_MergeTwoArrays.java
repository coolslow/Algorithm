package com.coolslow.leetcode.AStartup_2023_6;

import java.util.Arrays;

/**
 * @Title: 合并两个有序数组
 * @Description:
 *  给定两个按照非递减顺序排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n，分别表示nums1和nums2中的元素数目。
 *  请合并nums2到nums1中，合并后的数组同样按照非递减顺序排列。
 * @Rank: 简单
 *
 */
public class NO88_MergeTwoArrays {

    /**
     * 方法一：直观的方法，将数组nums2直接放入nums1中，再对nums1进行排序即可。
     * @param nums1 非递减顺序的数组nums1
     * @param m nums1中的元素个数
     * @param nums2 非递减顺序的数组nums2
     * @param n nums2中的元素个数
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }


    /**
     * 方法二：采用双指针的方法
     * 时间复杂度：O(m + n)
     * 空间复杂度：O(m + n)
     */
    public static void mergeWithTwoPointers(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int[] sorted = new int[m + n];

        int cur;
        while(p1 < m || p2 < n) {
            if(p1 == m) {
                cur = nums2[p2++];
            } else if(p2 == n) {
                cur = nums1[p1++];
            } else if(nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }

        System.arraycopy(sorted, 0, nums1, 0, m + n);
    }
}
