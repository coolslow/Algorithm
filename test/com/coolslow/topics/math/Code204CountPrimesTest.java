package com.coolslow.topics.math;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.math.Code204CountPrimes;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code204CountPrimesTest {

    @Test
    public void testSolution() {
        Code204CountPrimes solution = new Code204CountPrimes();
//        int n = 499979;
        int n = 27;
        int result = solution.countPrimes(n);
        MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }
}
