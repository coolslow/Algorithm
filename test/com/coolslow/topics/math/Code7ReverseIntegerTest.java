package com.coolslow.topics.math;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.math.Code7ReverseInteger;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code7ReverseIntegerTest {

    @Test
    public void testSolution() {
        Code7ReverseInteger solution = new Code7ReverseInteger();
        int nums = 123;
        int result = solution.reverse(nums);
        MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }

}
