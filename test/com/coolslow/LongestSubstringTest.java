package com.coolslow;

import com.coolslow.leetcode.top100.playground.LongestSubstringPlayground;
import org.junit.Assert;
import org.junit.Test;

public class LongestSubstringTest {

    @Test
    public void shouldReturnCorrectLongestSubstringNum() {
        String s = "abcabc"; // 最长子串 abc
        String s1 = "abcdeefghi"; // 最长子串 efghijklmn
        String s3 = "wcnmbb";

        int result = LongestSubstringPlayground.lengthOfLongestSubString(s);
        int result1 = LongestSubstringPlayground.lengthOfLongestSubstringWithSlidingWindow(s);
        int result2 = LongestSubstringPlayground.lengthOfLongestSubstringWithSlidingWindow(s1);
        int result3 = LongestSubstringPlayground.lengthOfLongestSubstringWithOptimizedSlidingWindow(s3);
        Assert.assertEquals(3, result);
        Assert.assertEquals(3, result1);
        Assert.assertEquals(5, result2);
        Assert.assertEquals(5, result3);
    }
}
