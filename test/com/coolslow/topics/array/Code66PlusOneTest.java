package com.coolslow.topics.array;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.array.Code66PlusOne;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code66PlusOneTest {

    @Test
    public void testSolution() {
        Code66PlusOne solution = new Code66PlusOne();
//        int[] nums = {1, 2, 3};
        int[] nums = {4, 3, 2, 1};
//        int[] nums = {9, 9, 9, 9};
        int[] result = solution.plusOne(nums);
        MyUtils.printArray(result);
    }
}
