package com.coolslow.leetcode.topics.array;

/**
 * 合并两个有序数组
 * by MrThanksgiving
 */
public class Code88MergeSortedArray {

    /**
     * <pre>
     * 题目：
     *      给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     *
     * 说明:
     *      初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     *      你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     *
     * 示例:
     *      输入:
     *      nums1 = [1,2,3,0,0,0], m = 3
     *      nums2 = [2,5,6],       n = 3
     *      输出: [1,2,2,3,5,6]
     * </pre>
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {// O(N^2) O(1)
        if (nums1 == null || nums2 == null) return;
        int l = m - 1, r = n - 1, k = nums1.length - 1;
        while (l >= 0 && r >= 0)
            nums1[k--] = nums1[l] > nums2[r] ? nums1[l--] : nums2[r--];
        while (l >= 0)
            nums1[k--] = nums1[l--];
        while (r >= 0)
            nums1[k--] = nums2[r--];
    }


    public void merge2(int[] nums1, int m, int[] nums2, int n) {// O(N^2) O(1)
        if (nums1 == null || nums2 == null) return;
        int[] contain = new int[m];
        System.arraycopy(nums1, 0, contain, 0, m);
        int l = 0, r = 0, k = 0;
        while (l < m && r < n)
            nums1[k++] = contain[l] < nums2[r] ? contain[l++] : nums2[r++];
        while (l < m)
            nums1[k++] = contain[l++];
        while (r < n)
            nums1[k++] = nums2[r++];
    }

    public void merge3(int[] nums1, int m, int[] nums2, int n) {// O(N^2) O(1)
        if (nums1 == null || nums2 == null) return;
        int k = m;
        int l = 0;
        int r = 0;
        while (l < k && r < n) {
            if (nums1[l] >= nums2[r]) {
                for (int i = k - 1; i >= l; i--) {
                    nums1[i + 1] = nums1[i];
                }
                nums1[l] = nums2[r++];
                k++;
            }
            l++;
        }
        while (r < n)
            nums1[l++] = nums2[r++];
    }

}
