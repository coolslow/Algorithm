package com.coolslow.topics.math;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.math.Code12IntegerToRoman;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code12IntegerToRomanTest {

    @Test
    public void testSolution() {
        Code12IntegerToRoman solution = new Code12IntegerToRoman();
        int[] n = {3, 4, 9, 58, 1994};
        for (int i : n) {
            String result = solution.intToRoman(i);
            MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
        }


    }
}
