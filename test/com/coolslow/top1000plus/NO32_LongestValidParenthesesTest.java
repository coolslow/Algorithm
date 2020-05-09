package com.coolslow.top1000plus;

import com.coolslow.leetcode.top1000plus.NO32_LongestValidParentheses;
import org.junit.Assert;
import org.junit.Test;

public class NO32_LongestValidParenthesesTest {

    @Test
    public void shouldFindLongestValidParentheses() {
        String s1 = "((())", s2 = "((((()))))";
        int result1 = NO32_LongestValidParentheses.longestValidParentheses(s1);
        int result2 = NO32_LongestValidParentheses.longestValidParentheses(s2);

        Assert.assertEquals(4, result1);
        Assert.assertEquals(10, result2);
    }
}
