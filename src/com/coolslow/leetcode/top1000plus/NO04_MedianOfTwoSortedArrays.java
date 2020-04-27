package com.coolslow.leetcode.top1000plus;

/**
 * 4. 寻找两个有序数组的中位数
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 *
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 */
public class NO04_MedianOfTwoSortedArrays {

    /**
     * 解法一：暴力解法
     * 先将两个数组合并，两个有序数组的合并也是归并排序中的一部分。然后根据数组长度是奇数还是偶数，返回中位数。
     *
     * 时间复杂度：O(m + n) 因为遍历的全部数组
     * 空间复杂度：O(m + n) 用于爆粗合并后的两个数组
     *
     * @param nums1 给定的第一个数组
     * @param nums2 给定的第二个数组
     * @return 返回两个有序数组的中位数
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length, n = nums2.length;

        // 创建一个用于存放合并两个数组的新的数组
        int[] nums = new int[m + n];

        // 处理第一个数组长度为0，第二个数组长度不为0的情况
        if (m == 0) {
            // 长度为偶数的情况
            if(n % 2 == 0) {
                return (nums2[n/2 - 1] + nums2[n/2]) / 2.0;
            }
            // 长度为奇数的情况
            else {
                return nums2[n/2];
            }
        }
        // 处理第一个数组长度不为0，第二个数组长度为0的情况
        if (n == 0) {
            // 长度为偶数的情况
            if(m % 2 == 0) {
                return (nums1[m/2 - 1] + nums1[m/2]) / 2.0;
            }
            // 长度为奇数的情况
            else {
                return nums1[m/2];
            }
        }

        // 开始处理两个数组长度均不为0的情况
        int count = 0, i = 0, j = 0;
        while(count != (m + n)) {
            if(i == m) {
                while(j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if(j == n) {
                while(i != m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }

            if(nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }

        if(count % 2 == 0) {
            return (nums[count/2 - 1] + nums[count/2]) / 2.0;
        } else {
            return nums[count / 2];
        }
    }

    /**
     * 解法三：
     * 上边的思路，时间复杂度都达不到题目的要求 O(log(m+n))，看到log,很明显，需要用到二分法解决该类问题。
     * 题目是求中位数，实际上是求第k小或第k大数的一种特殊情况
     *
     *
     * @param nums1 给定的第一个数组
     * @param nums2 给定的第二个数组
     * @return 返回两个有序数组的中位数
     */
//    public static double findMedianSortedArraysTheBestMethod(int[] nums1, int[] nums2) {
//
//    }
}
