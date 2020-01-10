package com.coolslow.topics.array;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.array.Code136SingleNumber;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code136SingleNumberTest {

    @Test
    public void testSolution() {
        Code136SingleNumber solution = new Code136SingleNumber();
//        int[] nums = {2, 2, 1};
        int[] nums = {4, 1, 2, 1, 2};
        int result = solution.singleNumber(nums);
        MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }
}
