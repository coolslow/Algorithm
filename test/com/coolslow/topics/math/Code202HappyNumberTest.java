package com.coolslow.topics.math;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.math.Code202HappyNumber;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code202HappyNumberTest {

    @Test
    public void testSolution() {
        Code202HappyNumber solution = new Code202HappyNumber();
        int input = 18;
        boolean result = solution.isHappy(input);
        MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }
}
