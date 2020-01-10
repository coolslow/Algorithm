package com.coolslow.topics.array;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.array.Code215KthLargestElementInAnArray;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code215KthLargestElementInAnArrayTest {

    @Test
    public void testSolution() {
        Code215KthLargestElementInAnArray solution = new Code215KthLargestElementInAnArray();
//        int[] nums = {3,2,1,5,6,4};
//        int k = 2;
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
//        int[] nums = {2,1};
//        int k = 2;
        int result = solution.findKthLargest2(nums, k);
        MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }
}
