package com.coolslow.topics.array;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.array.Code167TwoSumIIInputArrayIsSorted;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code167TwoSumIIInputArrayIsSortedTest {

    @Test
    public void testSolution() {
        Code167TwoSumIIInputArrayIsSorted solution = new Code167TwoSumIIInputArrayIsSorted();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(numbers, target);
        MyUtils.printArray(result);
    }
}
