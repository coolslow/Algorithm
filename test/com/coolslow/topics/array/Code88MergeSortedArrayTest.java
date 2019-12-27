package com.coolslow.topics.array;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.array.Code88MergeSortedArray;

/**
 * by MrThanksgiving
 */
public class Code88MergeSortedArrayTest {

    public void testSolution() {
        Code88MergeSortedArray solution = new Code88MergeSortedArray();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        solution.merge(nums1, m, nums2, n);
        MyUtils.printArray(nums1);
    }
}
