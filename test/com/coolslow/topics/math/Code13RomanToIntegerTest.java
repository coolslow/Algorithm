package com.coolslow.topics.math;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.math.Code13RomanToInteger;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code13RomanToIntegerTest {

    @Test
    public void testSolution() {
        Code13RomanToInteger solution = new Code13RomanToInteger();
        String[] ss = {"MCMXCIV", "LVIII", "IX", "IV", "III"};
        for (String s : ss) {
            int result = solution.romanToInt(s);
            MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
        }
    }
}
