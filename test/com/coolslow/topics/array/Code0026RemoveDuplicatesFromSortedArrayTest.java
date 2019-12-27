package com.coolslow.topics.array;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.array.Code0026RemoveDuplicatesFromSortedArray;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code0026RemoveDuplicatesFromSortedArrayTest {

    @Test
    public void testSolution() {
        Code0026RemoveDuplicatesFromSortedArray solution = new Code0026RemoveDuplicatesFromSortedArray();
//        int[] nums = {1, 1, 2};
//        int[] nums = {1, 2};
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int result = solution.removeDuplicates(nums);
        MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
        MyUtils.printArray(nums);
    }
}
