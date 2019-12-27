package com.coolslow.topics.array;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.array.Code080RemoveDuplicatesFromSortedArrayII;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code080RemoveDuplicatesFromSortedArrayIITest {

    @Test
    public void testSolution() {
        Code080RemoveDuplicatesFromSortedArrayII solution = new Code080RemoveDuplicatesFromSortedArrayII();
//        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int result = solution.removeDuplicates(nums);
        MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
        MyUtils.printArray(nums);
    }
}
