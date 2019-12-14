package com.coolslow;

import com.coolslow.leetcode.top100.ValidParentheses;
import org.junit.Assert;
import org.junit.Test;

public class ValidParenthesesTest {

    @Test
    public void shouldCheckParenthesesCorrectly() {
        String s1 = "()";
        String s2 = "{}[]";
        String s3 = "[]";
        String s4 = "(][{})";

        boolean result1 = ValidParentheses.isValidParentheses(s1);
        boolean result2 = ValidParentheses.isValidParentheses(s2);
        boolean result3 = ValidParentheses.isValidParentheses(s3);
        boolean result4 = ValidParentheses.isValidParentheses(s4);

        boolean res1 = ValidParentheses.isValidParenthesesShort(s1);

        Assert.assertTrue(result1);
        Assert.assertTrue(result2);
        Assert.assertTrue(result3);
        Assert.assertFalse(result4);

        Assert.assertTrue(res1);
    }
}
