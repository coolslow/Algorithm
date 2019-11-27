package com.coolslow;

import com.coolslow.leetcode.top100.playground.LongestSubstringPlayground;
import org.junit.Assert;
import org.junit.Test;

public class LongestSubstringTest {

    @Test
    public void shouldReturnCorrectLongestSubstringNum() {
        String s = "abcabc";

        int result = LongestSubstringPlayground.lengthOfLongestSubString(s);
        Assert.assertEquals(3, result);
    }
}
