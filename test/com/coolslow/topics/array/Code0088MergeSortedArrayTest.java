package com.coolslow.topics.array;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.array.Code0088MergeSortedArray;

/**
 * by MrThanksgiving
 */
public class Code0088MergeSortedArrayTest {

    public void testSolution() {
        Code0088MergeSortedArray solution = new Code0088MergeSortedArray();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        solution.merge(nums1, m, nums2, n);
        MyUtils.printArray(nums1);
    }
}
