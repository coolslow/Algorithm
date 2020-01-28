package com.coolslow.topics.math;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.math.Code172FactorialTrailingZeroes;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code172FactorialTrailingZeroesTest {


    @Test
    public void testSolution() {
        Code172FactorialTrailingZeroes solution = new Code172FactorialTrailingZeroes();
        int input = 30;
        int result = solution.trailingZeroes(input);
        MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }

}
