package com.coolslow.topics.array;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.array.Code350IntersectionOfTwoArraysII;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code350IntersectionOfTwoArraysIITest {

    @Test
    public void testSolution() {
        Code350IntersectionOfTwoArraysII solution = new Code350IntersectionOfTwoArraysII();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = solution.intersect(nums1, nums2);
        MyUtils.printArray(result);
    }
}
