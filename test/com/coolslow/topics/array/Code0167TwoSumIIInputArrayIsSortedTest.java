package com.coolslow.topics.array;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.array.Code0167TwoSumIIInputArrayIsSorted;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code0167TwoSumIIInputArrayIsSortedTest {

    @Test
    public void testSolution() {
        Code0167TwoSumIIInputArrayIsSorted solution = new Code0167TwoSumIIInputArrayIsSorted();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(numbers, target);
        MyUtils.printArray(result);
    }
}
