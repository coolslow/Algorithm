package com.coolslow.topics.string;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.string.Code20ValidParentheses;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code20ValidParenthesesTest {

    @Test
    public void testSolution() {
        Code20ValidParentheses solution = new Code20ValidParentheses();
        String input = "(";
        boolean result = solution.isValid(input);
        MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }
}
