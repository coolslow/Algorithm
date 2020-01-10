package com.coolslow.topics.math;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.math.Code326PowerOfThree;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code326PowerOfThreeTest {

    @Test
    public void testSolution() {
        Code326PowerOfThree solution = new Code326PowerOfThree();
        int n = 1;
        boolean result = solution.isPowerOfThree(n);
        MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }
}
