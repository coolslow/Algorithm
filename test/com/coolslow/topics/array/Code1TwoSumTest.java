package com.coolslow.topics.array;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.array.Code1TwoSum;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code1TwoSumTest {

    @Test
    public void testSolution() {
        Code1TwoSum solution = new Code1TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        MyUtils.printArray(result);
    }
}
