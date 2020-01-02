package com.coolslow;

import com.coolslow.leetcode.top100.NO20_ValidParentheses;
import org.junit.Assert;
import org.junit.Test;

public class NO20ValidParenthesesTest {

    @Test
    public void shouldCheckParenthesesCorrectly() {
        String s1 = "()";
        String s2 = "{}[]";
        String s3 = "[]";
        String s4 = "(][{})";

        boolean result1 = NO20_ValidParentheses.isValidParentheses(s1);
        boolean result2 = NO20_ValidParentheses.isValidParentheses(s2);
        boolean result3 = NO20_ValidParentheses.isValidParentheses(s3);
        boolean result4 = NO20_ValidParentheses.isValidParentheses(s4);

        boolean res1 = NO20_ValidParentheses.isValidParenthesesShort(s1);

        Assert.assertTrue(result1);
        Assert.assertTrue(result2);
        Assert.assertTrue(result3);
        Assert.assertFalse(result4);

        Assert.assertTrue(res1);
    }
}
