package com.coolslow.topics.bit;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.bit.Code190ReverseBits;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code190ReverseBitsTest {

    @Test
    public void testSolution() {
        Code190ReverseBits solution = new Code190ReverseBits();
        long n = Long.parseLong("11111111111111111111111111111101", 2);
        int result = solution.reverseBits((int)n);
        MyUtils.println(MyUtils.ANSI_RED + Integer.toString((int)n, 2) + MyUtils.ANSI_RESET);
        MyUtils.println(MyUtils.ANSI_RED + Integer.toString(result, 2) + MyUtils.ANSI_RESET);
    }
}
