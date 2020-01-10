package com.coolslow.topics.math;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.math.Code8StringToInteger;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code8StringToIntegerTest {

    @Test
    public void testSolution() {
        Code8StringToInteger solution = new Code8StringToInteger();
        String[] strings = {
                "42",
                "   -42",
                "4193 with words",
                "words and 987",
                "-91283472332",
                "+",
                "+-2",
                "18446744073709551617",
                "2147483648"
        };

        for (String s : strings) {
            int result = solution.myAToI2(s);
            MyUtils.println(s+"="+MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
        }

    }
}
