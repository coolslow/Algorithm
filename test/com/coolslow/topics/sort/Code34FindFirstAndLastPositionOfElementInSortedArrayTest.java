package com.coolslow.topics.sort;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.sort.Code34FindFirstAndLastPositionOfElementInSortedArray;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code34FindFirstAndLastPositionOfElementInSortedArrayTest {

    @Test
    public void testSolution() {
        Code34FindFirstAndLastPositionOfElementInSortedArray solution = new Code34FindFirstAndLastPositionOfElementInSortedArray();
//        int[] input = {5, 7,7,7,7,7, 7, 8, 8, 10};
//        int[] input = {5,7,7,8,8,10};
        int[] input = {1};
        int target = 1;
        int[] result = solution.searchRange(input, target);
        MyUtils.printArray(result);
    }
}
