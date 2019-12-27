package com.coolslow.topics.array;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.array.Code0209MinimumSizeSubArraySum;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code0209MinimumSizeSubArraySumTest {

    @Test
    public void testSolution() {
        Code0209MinimumSizeSubArraySum solution = new Code0209MinimumSizeSubArraySum();
        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
//        int[] nums = {1,2,3,4,5};
//        int s = 15;
        int result = solution.minSubArrayLen(s, nums);
        MyUtils.print(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }
}
