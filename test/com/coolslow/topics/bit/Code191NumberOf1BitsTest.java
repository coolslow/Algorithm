package com.coolslow.topics.bit;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.bit.Code191NumberOf1Bits;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code191NumberOf1BitsTest {

    @Test
    public void testSolution() {
        int n = Integer.parseUnsignedInt("11111111111111111111111111111101", 2);


        Code191NumberOf1Bits solution = new Code191NumberOf1Bits();
//        int n = 111;
        int result = solution.hammingWeight(n);
        MyUtils.println(MyUtils.ANSI_RED + n+"           "+result + MyUtils.ANSI_RESET);
    }
}
